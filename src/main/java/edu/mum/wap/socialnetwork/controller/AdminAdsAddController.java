package edu.mum.wap.socialnetwork.controller;

import edu.mum.wap.socialnetwork.model.Ads;
import edu.mum.wap.socialnetwork.service.AdsService;
import edu.mum.wap.socialnetwork.service.impl.AdsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet({"/ads_add"})
public class AdminAdsAddController extends HttpServlet {
    AdsService adsService = new AdsServiceImpl();

    public AdminAdsAddController() {
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String incomingId = req.getParameter("id");
        HttpSession session = req.getSession();
        LocalDate time = LocalDate.now();
        List<Ads> myAds = adsService.getAllAds();
        boolean status = Boolean.parseBoolean(req.getParameter("active"));
        String article = req.getParameter("article");
        String content = req.getParameter("content");
        String url = req.getParameter("url");
        String imgUrl = req.getParameter("imgURL");
        String location = req.getParameter("location");
        int age = Integer.parseInt(req.getParameter("ageRange")) + 5;
        int duration = Integer.parseInt(req.getParameter("duration"));


        if ("".equals(incomingId)) {
            int id = myAds.size() + 1;
            Ads bean = new Ads(status, id, article, content, url, imgUrl, time, location, age, duration);
            String statusMSG = "UN";
            if (adsService.addAds(bean)) {
                statusMSG = "Success";
                session.setAttribute("newAds", bean);
            }
            session.setAttribute("statusMSG", statusMSG);
        } else { //update hiih
            System.out.println("Edit hiih incomingId = " + incomingId);
            int id = Integer.parseInt(incomingId);
            boolean sta = Boolean.parseBoolean(req.getParameter("active"));
            String art = req.getParameter("article");
            String cont = req.getParameter("content");
            String ur =req.getParameter("url");
            String imUr = req.getParameter("imgURL");
            String loc = req.getParameter("location");
            LocalDate dat= LocalDate.now();
            int af = Integer.parseInt(req.getParameter("ageRange"));
            int dur = (Integer.parseInt(req.getParameter("duration")));

            Ads bean = new Ads(sta, id, art, cont, ur, imUr, dat, loc, af, dur);
            adsService.updateAds(bean);
            if(adsService.updateAds(bean)){
                System.out.println("Succ");

            }

        }

        resp.sendRedirect("ads_add.jsp");


    }
}
