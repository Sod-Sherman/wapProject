//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package edu.mum.wap.socialnetwork.controller;

import edu.mum.wap.socialnetwork.model.User;
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

@WebServlet({"/profile"})
public class ProfileController extends HttpServlet {
    UserService userService = new UserServiceImpl();


    public ProfileController() {
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        RequestDispatcher rd = null;

        User loggedInUser = (User) session.getAttribute("loggedInUser");


        if (loggedInUser != null) {

            req.setAttribute("loggedInUser", loggedInUser);

            User tempUser = new User(
                    req.getParameter("firstName"),
                    req.getParameter("lastName"),
                    req.getParameter("password"),
                    req.getParameter("email"),
                    req.getParameter("location"),
                    req.getParameter("phone"));

            tempUser.setUsername(loggedInUser.getUsername());

            userService.updateProfile(tempUser);

            rd = req.getRequestDispatcher("profile.jsp");

        } else {
            rd = req.getRequestDispatcher("login.jsp");
        }


        rd.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
