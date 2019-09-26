package edu.mum.wap.socialnetwork.controller.sod;

import edu.mum.wap.socialnetwork.model.Ads;
import edu.mum.wap.socialnetwork.model.Post;
import edu.mum.wap.socialnetwork.model.User;
import edu.mum.wap.socialnetwork.repository.PostRepository;
import edu.mum.wap.socialnetwork.repository.impl.PostRepositoryImpl;
import edu.mum.wap.socialnetwork.service.AdsService;
import edu.mum.wap.socialnetwork.service.PostService;
import edu.mum.wap.socialnetwork.service.impl.AdsServiceImpl;
import edu.mum.wap.socialnetwork.service.impl.PostServiceImpl;

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

    private PostService postService = new PostServiceImpl();

    private AdsService adsService = new AdsServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User loggedInUser = null;// = (User) session.getAttribute("loggedInUser");


            if (session.getAttribute("loggedInUser") == null) {
                resp.sendRedirect("login.jsp");
            } else {
                loggedInUser = (User) session.getAttribute("loggedInUser");

                PostRepository postRepository = PostRepositoryImpl.getInstance();
                List<Post> posts = postRepository.findAllActiveFollowersRecentPosts(loggedInUser);
//                List<Post> posts = postRepository.findAllActiveRecentPosts();
                if(posts == null) posts.add(postService.getEmptyPost());
                req.setAttribute("userPosts", posts);
//                System.out.println(posts.size());
                handleWeather(req);

                handleTwitterEmbed(req);

                handleAdsBanner(req);

                RequestDispatcher rd = req.getRequestDispatcher("timeline.jsp");
                rd.forward(req,resp);
            }
    }

    protected void handleWeather(HttpServletRequest req) {
        User loggedInUser = (User) req.getSession().getAttribute("loggedInUser");
        String city = loggedInUser.getLocation();
        req.setAttribute("city", city);
    }

    protected void handleTwitterEmbed(HttpServletRequest req) {
        User loggedInUser = (User) req.getSession().getAttribute("loggedInUser");
        req.setAttribute("twitUserName", loggedInUser.getTwitter());
    }

    protected void handleAdsBanner(HttpServletRequest req) {
        List<Ads> myAds = adsService.getAllAds();
//        List<Ads> activeAds = new ArrayList<>();
//        for(Ads ad : myAds){
//            if (ad.isActive()){
//                int i = 0;
//                activeAds.set(i, ad);
//                i++;
//            }
//        }
        req.setAttribute("adsAll", myAds);
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
