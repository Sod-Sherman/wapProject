package edu.mum.wap.socialnetwork.controller.tur;

import edu.mum.wap.socialnetwork.model.Post;
import edu.mum.wap.socialnetwork.model.User;
import edu.mum.wap.socialnetwork.service.PostService;
import edu.mum.wap.socialnetwork.service.UserService;
import edu.mum.wap.socialnetwork.service.impl.PostServiceImpl;
import edu.mum.wap.socialnetwork.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet({"/post_list"})
public class AdminPostController extends HttpServlet {
    UserService userService = new UserServiceImpl();
    PostService postService = new PostServiceImpl();

    public AdminPostController() {
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User tempUser = (User)session.getAttribute("loggedInUser");
        if (!tempUser.getUsername().equals("admin")) {
            resp.sendRedirect("login.jsp");
        }

        List<Post> myPosts = this.postService.getAllPosts();
        System.out.println("myPosts = " + myPosts);
        List<User> myUsers = this.userService.getAllUsers();
        session.setAttribute("postsAll", myPosts);
        session.setAttribute("usersAll", myUsers);
        RequestDispatcher rd = req.getRequestDispatcher("post_list.jsp");
        rd.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
