package edu.mum.wap.socialnetwork.controller;

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

@WebServlet("/profile")
public class ProfileController extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        RequestDispatcher rd = null;

        String firstNameInput = req.getParameter("name");
        System.out.println(firstNameInput+"name");
        String lastNameInput = req.getParameter("lastName");
        String usernameInput = req.getParameter("username");
        String phoneInput = req.getParameter("phone");
        String emailInput = req.getParameter("email");
        String locationInput = req.getParameter("location");
        String passwordInput = req.getParameter("password");


//        if(userService.equals(profileUser)){
//            statusProfile = "Success";
//            session.setAttribute("loggedInUser", statusProfile);
//        }
//        session.setAttribute("statusProfile", statusProfile);

        //statusMessage

        System.out.println(session.getAttribute("loggedInUser"));
        System.out.println("test");

        if(session.getAttribute("loggedInUser") == null){
            if("".equals(firstNameInput) || firstNameInput == null){
                rd = req.getRequestDispatcher("profile.jsp");
            }else if("".equals(lastNameInput) || lastNameInput == null){
                rd = req.getRequestDispatcher("profile.jsp");
            }else if("".equals(usernameInput) || usernameInput == null){
                rd = req.getRequestDispatcher("profile.jsp");
            }else if("".equals(phoneInput) || phoneInput == null){
                rd = req.getRequestDispatcher("profile.jsp");
            } else if ("".equals(emailInput) || emailInput == null){
                rd = req.getRequestDispatcher("profile.jsp");
            }else if ("".equals(locationInput) || locationInput == null){
                rd = req.getRequestDispatcher("profile.jsp");
            }else if("".equals(passwordInput) || passwordInput == null){
                rd = req.getRequestDispatcher("profile.jsp");
            }else {

                //User profileUser = new User(firstNameInput, lastNameInput, usernameInput, phoneInput, emailInput, locationInput, passwordInput);
                User profileUser = new User();
                profileUser.setFirstName(firstNameInput);
                profileUser.setLastName(lastNameInput);
                profileUser.setUsername(usernameInput);
                profileUser.setPhone(phoneInput);
                profileUser.setEmail(emailInput);
                profileUser.setLocation(locationInput);
                profileUser.setPassword(passwordInput);
                String statusProfile = "UnSuccess";
                Integer returnValue = userService.updateProfile(profileUser);

                if(returnValue != 0){
                    statusProfile = "Success";
                    session.setAttribute("loggedInUser", userService.findByUsername(profileUser.getUsername()));
                    if(returnValue == 2){
                        rd = req.getRequestDispatcher("profile.jsp");
                    }else{

                        statusProfile = "Account is not changed";
                        session.setAttribute("statusProfile", statusProfile);
                        rd = req.getRequestDispatcher("profile.jsp");
                    }
                }
            }
        }else{
            rd = req.getRequestDispatcher("/timeline");
        }
        System.out.println("test");
        rd.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
