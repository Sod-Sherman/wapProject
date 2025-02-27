//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package edu.mum.wap.socialnetwork.controller.puu;

import edu.mum.wap.socialnetwork.model.User;
import edu.mum.wap.socialnetwork.repository.UserRepository;
import edu.mum.wap.socialnetwork.repository.impl.UserRepositoryImpl;
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
import java.util.List;

@WebServlet({"/profile"})
public class ProfileController extends HttpServlet {
    UserService userService = new UserServiceImpl();
    UserRepository userRepository = UserRepositoryImpl.getInstance();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        RequestDispatcher rd = null;

        User loggedInUser = (User) session.getAttribute("loggedInUser");

        if (loggedInUser != null) {

            List<User> followers = loggedInUser.getFollowers();

            //req.setAttribute("loggedInUser", loggedInUser);
            req.setAttribute("postsNumber", loggedInUser.getPosts().size());
            req.setAttribute("followersNumber", followers.size());
            req.setAttribute("followers", loggedInUser.getFollowers());

            if (req.getParameter("UpdateProfileSubmitClicked") != null) {




//update profile
                String fName = req.getParameter("firstName");
                if(!fName.equals("")) loggedInUser.setFirstName(fName);

                String lName = req.getParameter("lastName");
                if(!lName.equals("")) loggedInUser.setLastName(lName);

                String passInput = req.getParameter("password");
                if(!passInput.equals("")) loggedInUser.setPassword(passInput);

                String emailInput = req.getParameter("email");
                if(!emailInput.equals("")) loggedInUser.setEmail(emailInput);

                String locationInput = req.getParameter("location");
                if(!locationInput.equals("")) loggedInUser.setLocation(locationInput);

                String phoneInput = req.getParameter("phone");
                if(!phoneInput.equals("")) loggedInUser.setPhone(phoneInput);


                userService.updateProfile(loggedInUser);
//update end
            }
            rd = req.getRequestDispatcher("profile.jsp");

        } else {
            rd = req.getRequestDispatcher("login.jsp");
        }

        if (req.getParameter("id") != null) {
            Integer followerId = Integer.parseInt(req.getParameter("id"));
            if (followerId >= userRepository.findAllUsers().size()) return;

            User follower = userRepository.findByUserId(followerId);
            req.setAttribute("follower", follower);
            req.setAttribute("followersFollowerNumber", follower.getFollowers().size());
            req.setAttribute("followerPostsNumber", follower.getPosts().size());

            rd = req.getRequestDispatcher("profile.jsp");
        }


        rd.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
