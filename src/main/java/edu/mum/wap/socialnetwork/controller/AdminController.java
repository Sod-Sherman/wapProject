package edu.mum.wap.socialnetwork.controller;

import edu.mum.wap.socialnetwork.model.Post;
import edu.mum.wap.socialnetwork.model.User;
import edu.mum.wap.socialnetwork.service.PostService;
import edu.mum.wap.socialnetwork.service.PostServiceImpl;
import edu.mum.wap.socialnetwork.service.UserService;
import edu.mum.wap.socialnetwork.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/admin")
public class AdminController extends HttpServlet {
    UserService userService = new UserServiceImpl();
    PostService postService = new PostServiceImpl();

    public AdminController(){

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        User tempUser = (User)session.getAttribute("loggedInUser");
        if(!tempUser.getUsername().equals("admin")){
            out.println("Unauthorized access!");
            resp.sendRedirect("timeline.jsp");
        }
        List<User> myUsers = userService.getAllUsers();
        session.setAttribute("usersAll", myUsers);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}
