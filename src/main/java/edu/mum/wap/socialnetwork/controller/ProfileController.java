package edu.mum.wap.socialnetwork.controller;

import edu.mum.wap.socialnetwork.model.User;
import edu.mum.wap.socialnetwork.service.UserService;
import edu.mum.wap.socialnetwork.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/profile")
public class ProfileController extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String firstNameInput = req.getParameter("firstName");
        String lastNameInput = req.getParameter("lastName");
        String usernameInput = req.getParameter("username");
        String phoneInput = req.getParameter("phone");
        String emailInput = req.getParameter("email");
        String locationInput = req.getParameter("location");
        String passwordInput = req.getParameter("password");

        User profileUser = new User(firstNameInput, lastNameInput, usernameInput, phoneInput, emailInput, locationInput, passwordInput);

        String statusProfile = "UnSuccess";

        if(userService.updateProfile(profileUser)){
            statusProfile = "Success";
            session.setAttribute("loggedInUser", statusProfile);
        }
        session.setAttribute("statusProfile", statusProfile);
        resp.sendRedirect("profile.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
