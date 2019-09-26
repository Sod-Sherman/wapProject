package edu.mum.wap.socialnetwork.controller.puu;

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

@WebServlet("/user")
public class UserController extends HttpServlet {
    UserService userService = new UserServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();


        String firstNameInput = req.getParameter("firstName");
        String lastNameInput = req.getParameter("lastName");
        String usernameInput = req.getParameter("username");
        String passwordInput = req.getParameter("password");
        String emailInput = req.getParameter("email");



        User bean = new User(firstNameInput, lastNameInput, usernameInput, passwordInput, emailInput);

        String statusMsg = "UnSuccess";
        if (userService.addUser(bean)) {
            statusMsg = "Success";
            session.setAttribute("loggedInUser", bean);
        }
        req.setAttribute("statusMsg", statusMsg);


        resp.sendRedirect("profile.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
