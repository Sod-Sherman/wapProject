package edu.mum.wap.socialnetwork.controller.tur;

import edu.mum.wap.socialnetwork.model.Ads;
import edu.mum.wap.socialnetwork.model.Post;
import edu.mum.wap.socialnetwork.model.User;
import edu.mum.wap.socialnetwork.service.AdsService;
import edu.mum.wap.socialnetwork.service.PostService;
import edu.mum.wap.socialnetwork.service.impl.AdsServiceImpl;
import edu.mum.wap.socialnetwork.service.impl.PostServiceImpl;
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
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/admin")
public class AdminController extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    private PostService postService = new PostServiceImpl();
    private AdsService adsService = new AdsServiceImpl();
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
        List<Post> myPosts = postService.getAllPosts();
        List<Ads> myAds = adsService.getAllAds();
        session.setAttribute("adsAll", myAds);
        session.setAttribute("postsAll", myPosts);
        //
        // resp.sendRedirect("admin.jsp");
        RequestDispatcher rd = req.getRequestDispatcher("admin.jsp");
        rd.forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}
