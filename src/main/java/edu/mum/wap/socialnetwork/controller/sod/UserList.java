package edu.mum.wap.socialnetwork.controller.sod;

import edu.mum.wap.socialnetwork.model.User;
import edu.mum.wap.socialnetwork.repository.impl.UserRepositoryImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet("/userlist")
public class UserList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = null;
        UserRepositoryImpl userRepository = UserRepositoryImpl.getInstance();
        User loggedInUser = (User) req.getSession().getAttribute("loggedInUser");
        if (loggedInUser != null) {
            List<User> allUsers = userRepository.findAllUsers();
            req.setAttribute("allUsers", allUsers);

            HashMap<Integer, Boolean> hashMap = new HashMap<>();
            for (User user : allUsers) {
                if (userRepository.isFollower(loggedInUser, user))
                    hashMap.put(user.getId(), true);
                else
                    hashMap.put(user.getId(), false);
            }
            System.out.println("hashMap = " + hashMap);
            req.setAttribute("followHash", hashMap);


            if (req.getParameter("userIdToFollow") != null) { //follow hiih
                System.out.println("userIdToFollow = " + req.getParameter("userIdToFollow"));

                Integer userIdToFollow = Integer.parseInt(req.getParameter("userIdToFollow"));
                userRepository.addFollower(loggedInUser, userRepository.findByUserId(userIdToFollow));

            }
            rd = req.getRequestDispatcher("userlist.jsp");
        } else {
            rd = req.getRequestDispatcher("login.jsp");
        }

        rd.forward(req, resp);
    }
}
