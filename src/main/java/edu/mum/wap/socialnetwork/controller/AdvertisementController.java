package edu.mum.wap.socialnetwork.controller;

import edu.mum.wap.socialnetwork.repository.AdsRepositoryImpl;
import edu.mum.wap.socialnetwork.service.AdsService;
import edu.mum.wap.socialnetwork.service.impl.AdsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

@WebServlet("/advertisement")
public class AdvertisementController extends HttpServlet {

    @Override
    public void init() throws ServletException{
        AdsRepositoryImpl.getInstance();
    }

    private HttpSession session;

    private AdsService adsService = new AdsServiceImpl();


}
