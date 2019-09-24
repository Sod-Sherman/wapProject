package edu.mum.wap.socialnetwork.controller;

import edu.mum.wap.socialnetwork.model.Ads;
import edu.mum.wap.socialnetwork.service.AdsService;
import edu.mum.wap.socialnetwork.service.impl.AdsServiceImpl;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet({"/ads_add"})
public class AdminAdsAddController extends HttpServlet {
    AdsService adsService = new AdsServiceImpl();

    public AdminAdsAddController() {
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<Ads> myAds = adsService.getAllAds();
        int id = myAds.size() + 1;
        String article = req.getParameter("article");
        String content = req.getParameter("content");
        String url = req.getParameter("url");
        String imgUrl = req.getParameter("imgUrl");

        Ads bean = new Ads(id,article,content,url,imgUrl);
        String statusMSG = "UN";
        if(adsService.addAds(bean)){
            statusMSG = "Success";
            session.setAttribute("newAds",bean);
        }
        session.setAttribute("statusMSG",statusMSG);
        resp.sendRedirect("ads_add.jsp");


    }
}
