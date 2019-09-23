package edu.mum.wap.socialnetwork.controller;

import edu.mum.wap.socialnetwork.model.User;
import edu.mum.wap.socialnetwork.service.UserService;
import edu.mum.wap.socialnetwork.service.impl.UserServiceImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet({"/login"})
public class LoginController extends HttpServlet {
    UserService userService = new UserServiceImpl();

    public LoginController() {

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String usernameInput = req.getParameter("username");
        String passwordInput = req.getParameter("pass");
        User newUser = new User();
        newUser.setUsername(usernameInput);
        newUser.setPassword(passwordInput);
        String status = "unSuccess";
        if (userService.login(newUser) != 0) {
            status = "Success";
            session.setAttribute("loggedInUser", newUser);
        }else {
            status = "password or username incorrect";
        }

        session.setAttribute("status", status);
        resp.sendRedirect("timeline.jsp");
    }
}
