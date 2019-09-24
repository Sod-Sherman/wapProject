package edu.mum.wap.socialnetwork.controller.sod;

import edu.mum.wap.socialnetwork.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/follow")
public class FollowController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //No Login then redirect login.jsp
        User loggedInUser = (User) req.getSession().getAttribute("loggedInUser");
        if(loggedInUser == null) resp.sendRedirect("login.jsp");

        String fullNamePoster = (String) req.getAttribute("fullNameOfPoster");
        System.out.println("fullNamePoster = " + fullNamePoster);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doGet(req,resp);

    }
}
