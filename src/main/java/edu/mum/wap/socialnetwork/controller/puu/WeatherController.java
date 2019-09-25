package edu.mum.wap.socialnetwork.controller.puu;

import edu.mum.wap.socialnetwork.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/weather")
public class WeatherController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = null;
        User loggedInUser = (User) req.getSession().getAttribute("loggedInUser");
        if (loggedInUser != null) {

            String city = loggedInUser.getLocation();
            req.setAttribute("city", city);
            System.out.println("city = " + city);
            rd = req.getRequestDispatcher("weather.jsp");
        } else {
            rd = req.getRequestDispatcher("login.jsp");
        }
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
