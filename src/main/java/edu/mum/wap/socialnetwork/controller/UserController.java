package edu.mum.wap.socialnetwork.controller;

import edu.mum.wap.socialnetwork.model.User;
import edu.mum.wap.socialnetwork.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user")
public class UserController extends HttpServlet {
    UserService userService;

    public UserController() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

//        resp.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = resp.getWriter();

        String firstNameInput = req.getParameter("firstName");
        String lastNameInput = req.getParameter("lastName");
        String usernameInput = req.getParameter("username");
        String passwordInput = req.getParameter("password");
        String emailInput = req.getParameter("email");

        User bean = new User(firstNameInput, lastNameInput, usernameInput, passwordInput, emailInput);

        //boolean status = bean.validate();

        String statusMsg = "UnSuccess";
        if(userService.addUser(bean)) {
            statusMsg = "Success";
            session.setAttribute("loggedInUser", bean);
        }
        session.setAttribute("statusMsg", statusMsg);

//        RequestDispatcher rd = req.getRequestDispatcher("signup-success.jsp");
//        rd.forward(req, resp);

        resp.sendRedirect("signup-success.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
