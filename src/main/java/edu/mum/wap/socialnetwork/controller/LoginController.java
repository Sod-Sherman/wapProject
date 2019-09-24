package edu.mum.wap.socialnetwork.controller;

import edu.mum.wap.socialnetwork.model.User;
import edu.mum.wap.socialnetwork.repository.PostRepositoryImpl;
import edu.mum.wap.socialnetwork.repository.UserRepositoryImpl;
import edu.mum.wap.socialnetwork.service.UserService;
import edu.mum.wap.socialnetwork.service.impl.UserServiceImpl;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet({"/login"})
public class LoginController extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    public void init() throws ServletException {
        UserRepositoryImpl.getInstance();
        PostRepositoryImpl.getInstance();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        RequestDispatcher rd = null;

        if (session.getAttribute("loggedInUser") == null) {

            String usernameInput = req.getParameter("username");

            if ("".equals(usernameInput) || usernameInput == null)
                rd = req.getRequestDispatcher("login.jsp");
            else {

                String passwordInput = req.getParameter("pass");
                User newUser = new User();
                newUser.setUsername(usernameInput);
                newUser.setPassword(passwordInput);
                String status = "unSuccess";
                Integer returnValue = userService.login(newUser);

                if (returnValue != 0) {
                    status = "Success";
                    session.setAttribute("loggedInUser", userService.findByUsername(newUser.getUsername()));
                    if (returnValue == 2)
                        rd = req.getRequestDispatcher("admin.jsp");
                    else
                        rd = req.getRequestDispatcher("timeline");
                } else {
                    status = "password or username incorrect";
                    session.setAttribute("status", status);
                    rd = req.getRequestDispatcher("login.jsp");
                }
            }
        } else {
            rd = req.getRequestDispatcher("/timeline");
        }
        rd.forward(req, resp);

    }
}
