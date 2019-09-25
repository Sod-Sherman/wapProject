package edu.mum.wap.socialnetwork.controller.sod;

import edu.mum.wap.socialnetwork.model.Post;
import edu.mum.wap.socialnetwork.model.User;
import edu.mum.wap.socialnetwork.repository.impl.PostRepositoryImpl;
import edu.mum.wap.socialnetwork.repository.impl.UserRepositoryImpl;
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
import java.io.IOException;
import java.util.List;

@WebServlet("/follow")
public class FollowController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PostRepositoryImpl postRepository = PostRepositoryImpl.getInstance();
        UserRepositoryImpl userRepository = UserRepositoryImpl.getInstance();
        RequestDispatcher rd = req.getRequestDispatcher("timeline.jsp");

        //No Login then redirect login.jsp
        User loggedInUser = (User) req.getSession().getAttribute("loggedInUser");
        if (loggedInUser == null) resp.sendRedirect("login.jsp");

        if (req.getParameter("id") != null) { //add follower
            Integer id = Integer.parseInt(req.getParameter("id"));
            if (id >= userRepository.findAllUsers().size()) return;
            Post thePost = postRepository.getPostById(id);
            if (loggedInUser.getId() != thePost.getUser().getId())
                userRepository.addFollower(loggedInUser, thePost.getUser());


            List<Post> userPosts = thePost.getUser().getPosts();
            req.setAttribute("userPosts", userPosts);
            rd = req.getRequestDispatcher("profile");
        }

        if (req.getParameter("idProfile") != null) {
            Integer followerId = Integer.parseInt(req.getParameter("idProfile"));
            if (followerId >= userRepository.findAllUsers().size()) return;

            System.out.println("followerId = " + followerId);
            UserService userService = new UserServiceImpl();
            PostService postService = new PostServiceImpl();
//            List<Post> posts = userService.getPosts(userRepository.findByUserId(followerId));
            List<Post> posts = postRepository.findAllActiveFollowersRecentPosts(userRepository.findByUserId(followerId));
            //List<Post> posts = userService.getAllPosts();
            if (posts == null) posts.add(postService.getEmptyPost());
            req.setAttribute("userPosts", posts);
            rd = req.getRequestDispatcher("timeline.jsp");

        }

        if(req.getParameter("idUnFollow") != null){
            Integer postId = Integer.parseInt(req.getParameter("idUnFollow"));
            Post thePost = postRepository.getPostById(postId);
            if(userRepository.isFollower(loggedInUser, thePost.getUser()))
                req.setAttribute("followed", thePost.getUser());
            rd = req.getRequestDispatcher("timeline.jsp");
        }

        rd.forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doGet(req, resp);

    }
}
