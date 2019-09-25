//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package edu.mum.wap.socialnetwork.controller.tur;

import edu.mum.wap.socialnetwork.model.Ads;
import edu.mum.wap.socialnetwork.model.User;
import edu.mum.wap.socialnetwork.service.AdsService;
import edu.mum.wap.socialnetwork.service.UserService;
import edu.mum.wap.socialnetwork.service.impl.AdsServiceImpl;
import edu.mum.wap.socialnetwork.service.impl.UserServiceImpl;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet({"/ads_list"})
public class AdminAdsController extends HttpServlet {
    UserService userService = new UserServiceImpl();
    AdsService adsService = new AdsServiceImpl();

    public AdminAdsController() {
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User tempUser = (User)session.getAttribute("loggedInUser");
        if (!tempUser.getUsername().equals("admin")) {
            resp.sendRedirect("login.jsp");
        }
        List<Ads> myAds = adsService.getAllAds();
        session.setAttribute("adsAll", myAds);
        RequestDispatcher rd = req.getRequestDispatcher("ads_list.jsp");
        rd.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
