package edu.mum.wap.socialnetwork.controller.tur;

import edu.mum.wap.socialnetwork.model.Ads;
import edu.mum.wap.socialnetwork.model.User;
import edu.mum.wap.socialnetwork.service.AdsService;
import edu.mum.wap.socialnetwork.service.UserService;
import edu.mum.wap.socialnetwork.service.impl.AdsServiceImpl;
import edu.mum.wap.socialnetwork.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/twit")
public class TwitController extends HttpServlet {
    UserService userService = new UserServiceImpl();
    public TwitController() {
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User myUser = userService.findByUsername(req.getParameter("username"));
        if(userService.getAllUsers().contains(myUser)){
            session.setAttribute("loggedInUser",myUser);
        }
        RequestDispatcher rd = req.getRequestDispatcher("twit.jsp");
        rd.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
