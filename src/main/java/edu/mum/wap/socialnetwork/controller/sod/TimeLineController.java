package edu.mum.wap.socialnetwork.controller.sod;

import edu.mum.wap.socialnetwork.model.Post;
import edu.mum.wap.socialnetwork.model.User;
import edu.mum.wap.socialnetwork.repository.PostRepository;
import edu.mum.wap.socialnetwork.repository.impl.PostRepositoryImpl;
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

@WebServlet("/timeline")
public class TimeLineController extends HttpServlet {

    private UserService userService = new UserServiceImpl();
    private PostService postService = new PostServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User loggedInUser = null;// = (User) session.getAttribute("loggedInUser");


            if (session.getAttribute("loggedInUser") == null) {
                resp.sendRedirect("login.jsp");
            } else {
                loggedInUser = (User) session.getAttribute("loggedInUser");

//                List<Post> posts = userService.getPosts(loggedInUser);
//                List<Post> posts = userService.getAllPosts();
                PostRepository postRepository = PostRepositoryImpl.getInstance();
                List<Post> posts = postRepository.findAllActiveFollowersRecentPosts(loggedInUser);
                if(posts == null) posts.add(postService.getEmptyPost());
                req.setAttribute("userPosts", posts);

                RequestDispatcher rd = req.getRequestDispatcher("timeline.jsp");
                rd.forward(req,resp);
            }
    }




    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
