package edu.mum.wap.socialnetwork.controller.tur;

import edu.mum.wap.socialnetwork.model.Ads;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ads")
public class AdvertisementController extends HttpServlet {
    AdsService adsService = new AdsServiceImpl();

    public AdvertisementController() {
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<Ads> myAds = adsService.getAllAds();
        List<Ads> activeAds = new ArrayList<>();
        for(Ads ad : myAds){
            if (ad.isActive()){
                int i = 0;
                activeAds.set(i, ad);
                i++;
            }
        }
        session.setAttribute("adsAll", activeAds);
        RequestDispatcher rd = req.getRequestDispatcher("ads.jsp");
        rd.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
