package edu.mum.wap.socialnetwork.controller;

import edu.mum.wap.socialnetwork.model.User;
import edu.mum.wap.socialnetwork.repository.UserRepository;
import edu.mum.wap.socialnetwork.service.UserService;
import edu.mum.wap.socialnetwork.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/timeline")
public class TimeLineController extends HttpServlet {
    private HttpSession session;
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        session = req.getSession();
        User loggedInUser;
        try {


            if (session.getAttribute("loggedInUser") == null) {

                // tur loggedInUser bga gej uzeye
                loggedInUser = userService.findByUsername("sod");
                session.setAttribute("loggedInUser", loggedInUser);

                resp.sendRedirect("/login.jsp");
            } else {
                loggedInUser = (User) session.getAttribute("loggedInUser");
            }

            session.setAttribute("userPosts", userService.getPosts(loggedInUser));
            System.out.println(loggedInUser);
            System.out.println(userService.getPosts(loggedInUser));

            RequestDispatcher rd = req.getRequestDispatcher("timeline.jsp");
            rd.forward(req,resp);

//            resp.sendRedirect("/wapProject/timeline.jsp");
        } catch (SecurityException e) {
            System.out.println(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
