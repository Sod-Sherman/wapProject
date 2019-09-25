//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package edu.mum.wap.socialnetwork.controller.tur;

import edu.mum.wap.socialnetwork.model.User;
import edu.mum.wap.socialnetwork.service.UserService;
import edu.mum.wap.socialnetwork.service.impl.UserServiceImpl;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet({"/user_list"})
public class AdminUserController extends HttpServlet {
    UserService userService = new UserServiceImpl();

    public AdminUserController() {
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User tempUser = (User)session.getAttribute("loggedInUser");
        if (!tempUser.getUsername().equals("admin")) {
            resp.sendRedirect("login.jsp");
        }

        List<User> myUsers = this.userService.getAllUsers();
        session.setAttribute("usersAll", myUsers);
        RequestDispatcher rd = req.getRequestDispatcher("user_list.jsp");
        rd.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
