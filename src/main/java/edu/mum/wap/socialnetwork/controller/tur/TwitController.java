package edu.mum.wap.socialnetwork.controller.tur;

import edu.mum.wap.socialnetwork.model.User;
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

@WebServlet("/twit")
public class TwitController extends HttpServlet {
    UserService userService = new UserServiceImpl();
    public TwitController() {
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        RequestDispatcher rd = null;

        User loggedInUser = (User) req.getSession().getAttribute("loggedInUser");
        if (loggedInUser != null) {
            req.setAttribute("twitUserName", loggedInUser.getTwitter());
            rd = req.getRequestDispatcher("twit.jsp");
        }
        else {
            rd = req.getRequestDispatcher("login.jsp");
        }
        rd.forward(req, resp);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
