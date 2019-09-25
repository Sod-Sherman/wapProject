package edu.mum.wap.socialnetwork.controller.puu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/logout")
public class LogoutController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String logout = req.getParameter("logout");
        System.out.println("logout = " + logout);

        if(!"LogOUT".equals(logout)){
            req.getSession().invalidate();
            PrintWriter out = resp.getWriter();
            out.print("LogOUT");
            //resp.sendRedirect("login.jsp");
        }
    }
}
