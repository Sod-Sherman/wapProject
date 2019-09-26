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
import java.util.ArrayList;
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
        HttpSession session = req.getSession();
        User tempUser = (User)session.getAttribute("loggedInUser");
        if(!tempUser.getUsername().equals("admin")){
            resp.sendRedirect("timeline.jsp");
        }
        List<User> myUsers = userService.getAllUsers();
        int userz = myUsers.size();
        req.setAttribute("userz",userz);
        session.setAttribute("usersAll", myUsers);
        List<Post> myPosts = postService.getAllPosts();
        List<Ads> myAds = adsService.getAllAds();
        req.setAttribute("adsAll", myAds);
        int postz = myPosts.size();
        req.setAttribute("postz",postz);
        req.setAttribute("postsAll", myPosts);
        int activeAds = 0;
        for(Ads ad: myAds){
            if(ad.isActive()){
                activeAds++;
            }
        }
        int notHealthy = 0;
        for(Post p : myPosts){
            if(!p.isHealthy()){
                notHealthy++;
            }
        }
        int adz = myAds.size();
        req.setAttribute("adz",adz);
        req.setAttribute("activeAdz",activeAds);
        req.setAttribute("badPost", notHealthy);
        //
        // resp.sendRedirect("admin.jsp");
        RequestDispatcher rd = req.getRequestDispatcher("admin.jsp");
        rd.forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}
