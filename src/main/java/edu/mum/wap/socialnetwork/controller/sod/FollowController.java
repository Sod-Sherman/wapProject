package edu.mum.wap.socialnetwork.controller.sod;

import edu.mum.wap.socialnetwork.model.Post;
import edu.mum.wap.socialnetwork.model.User;
import edu.mum.wap.socialnetwork.repository.impl.PostRepositoryImpl;
import edu.mum.wap.socialnetwork.repository.impl.UserRepositoryImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/follow")
public class FollowController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PostRepositoryImpl postRepository = PostRepositoryImpl.getInstance();
        UserRepositoryImpl userRepository = UserRepositoryImpl.getInstance();

        //No Login then redirect login.jsp
        User loggedInUser = (User) req.getSession().getAttribute("loggedInUser");
        if(loggedInUser == null) resp.sendRedirect("login.jsp");

        Integer id = Integer.parseInt(req.getParameter("id")); //(String) req.getAttribute("fullNameOfPoster");
        Post thePost = postRepository.getPostById(id);
        System.out.println("thePost = " + thePost);
        
        userRepository.addFollower(loggedInUser, thePost.getUser());

        System.out.println("loggedInUser.getFollowers().toString() = " + loggedInUser.getFollowers().toString());

        List<Post> userPosts = thePost.getUser().getPosts();
        req.setAttribute("userPosts",userPosts);
        RequestDispatcher rd = req.getRequestDispatcher("timeline.jsp");
        rd.forward(req,resp);
        

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doGet(req,resp);

    }
}
