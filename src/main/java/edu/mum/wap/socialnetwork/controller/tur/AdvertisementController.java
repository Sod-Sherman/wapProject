package edu.mum.wap.socialnetwork.controller.tur;

import edu.mum.wap.socialnetwork.model.Ads;
import edu.mum.wap.socialnetwork.model.User;
import edu.mum.wap.socialnetwork.repository.impl.AdsRepositoryImpl;
import edu.mum.wap.socialnetwork.service.AdsService;
import edu.mum.wap.socialnetwork.service.impl.AdsServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/ads")
public class AdvertisementController extends HttpServlet {
    AdsService adsService = new AdsServiceImpl();

    public AdvertisementController() {
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User tempUser = (User)session.getAttribute("loggedInUser");
        if (!tempUser.getUsername().equals("admin")) {
            resp.sendRedirect("login.jsp");
        }
        List<Ads> myAds = adsService.getAllAds();
        session.setAttribute("adsAll", myAds);
        RequestDispatcher rd = req.getRequestDispatcher("ads.jsp");
        rd.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
