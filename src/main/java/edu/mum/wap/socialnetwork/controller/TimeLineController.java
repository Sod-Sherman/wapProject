package edu.mum.wap.socialnetwork.controller;

import edu.mum.wap.socialnetwork.model.Post;
import edu.mum.wap.socialnetwork.model.User;
import edu.mum.wap.socialnetwork.repository.PostRepositoryImpl;
import edu.mum.wap.socialnetwork.repository.UserRepository;
import edu.mum.wap.socialnetwork.repository.UserRepositoryImpl;
import edu.mum.wap.socialnetwork.service.PostService;
import edu.mum.wap.socialnetwork.service.PostServiceImpl;
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
import java.util.List;

@WebServlet("/timeline")
public class TimeLineController extends HttpServlet {
    @Override
    public void init() throws ServletException {
        UserRepositoryImpl.getInstance();
        PostRepositoryImpl.getInstance();

    }

    private HttpSession session;

    private UserService userService = new UserServiceImpl();
    private PostService postService = new PostServiceImpl();


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
            List<Post> posts = userService.getPosts(loggedInUser);
            if(posts == null) posts.add(postService.getEmptyPost());
            session.setAttribute("userPosts", posts);
            System.out.println(loggedInUser);
            System.out.println(userService.getPosts(loggedInUser));

//            RequestDispatcher rd = req.getRequestDispatcher("/wapProject/timeline.jsp");
//            rd.forward(req,resp);

            resp.sendRedirect("/wapProject/timeline.jsp");
        } catch (SecurityException e) {
            System.out.println(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
