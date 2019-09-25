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

@WebServlet({"/user_ban"})
public class AdminUserEditController extends HttpServlet {
    UserService userService = new UserServiceImpl();

    public AdminUserEditController() {
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String page = "";
        try {
            User tempUser = userService.findByUsername(req.getParameter("user_name"));
            if(tempUser.getActive()){
                tempUser.setActive(false);
            } else {
                tempUser.setActive(true);
            }

        } catch (Exception e) {
            page = "advertisement.jsp";
        } finally {
            page = "user_list.jsp";
        }
        RequestDispatcher dd=req.getRequestDispatcher("user_list.jsp");
        dd.forward(req, resp);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
