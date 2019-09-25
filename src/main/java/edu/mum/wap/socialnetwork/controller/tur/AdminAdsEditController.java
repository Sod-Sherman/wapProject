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

@WebServlet({"/ads_edit"})
public class AdminAdsEditController extends HttpServlet {
    AdsService adsService = new AdsServiceImpl();

    public AdminAdsEditController() {
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        RequestDispatcher rd = null;

        int adsId = Integer.parseInt(req.getParameter("ads_id"));
        Ads tempAds = adsService.findByAdsId(adsId);

        // Ads editAds = (Ads) session.getAttribute("editAds");

//
//        if(editAds != null){
//            req.setAttribute("editAds", editAds);
//
//            Ads tempAds = new Ads(req.getParameter("article"));
        //   adsService.updateAds(tempAds);
//
////
//
//
//        adsService.updateAds(tempAds);

//            rd = req.getRequestDispatcher("ads_list.jsp");

        req.setAttribute("myAds", tempAds);

        rd = req.getRequestDispatcher("ads_view.jsp");
        rd.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
