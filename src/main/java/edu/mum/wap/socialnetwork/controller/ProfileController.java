//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package edu.mum.wap.socialnetwork.controller;

import edu.mum.wap.socialnetwork.model.User;
import edu.mum.wap.socialnetwork.service.UserService;
import edu.mum.wap.socialnetwork.service.impl.UserServiceImpl;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet({"/profile"})
public class ProfileController extends HttpServlet {
    UserService userService = new UserServiceImpl();

    public ProfileController() {
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        RequestDispatcher rd = null;

        String firstNameInput = req.getParameter("name");
        System.out.println(firstNameInput + "name");
        String lastNameInput = req.getParameter("lastName");
        String usernameInput = req.getParameter("username");
        String phoneInput = req.getParameter("phone");
        String emailInput = req.getParameter("email");
        String locationInput = req.getParameter("location");
        String passwordInput = req.getParameter("password");
        System.out.println(session.getAttribute("loggedInUser"));
        System.out.println("test");
        if (session.getAttribute("loggedInUser") == null) {
            if (!"".equals(firstNameInput) && firstNameInput != null) {
                if (!"".equals(lastNameInput) && lastNameInput != null) {
                    if (!"".equals(usernameInput) && usernameInput != null) {
                        if (!"".equals(phoneInput) && phoneInput != null) {
                            if (!"".equals(emailInput) && emailInput != null) {
                                if (!"".equals(locationInput) && locationInput != null) {
                                    if (!"".equals(passwordInput) && passwordInput != null) {
                                        User profileUser = new User();
                                        profileUser.setFirstName(firstNameInput);
                                        profileUser.setLastName(lastNameInput);
                                        profileUser.setUsername(usernameInput);
                                        profileUser.setPhone(phoneInput);
                                        profileUser.setEmail(emailInput);
                                        profileUser.setLocation(locationInput);
                                        profileUser.setPassword(passwordInput);
                                        String statusProfile = "UnSuccess";
                                        Integer returnValue = this.userService.updateProfile(profileUser);
                                        if (returnValue != 0) {
                                            statusProfile = "Success";
                                            session.setAttribute("loggedInUser", this.userService.findByUsername(profileUser.getUsername()));
                                            if (returnValue == 2) {
                                                rd = req.getRequestDispatcher("profile.jsp");
                                            } else {
                                                statusProfile = "Account is not changed";
                                                session.setAttribute("statusProfile", statusProfile);
                                                rd = req.getRequestDispatcher("profile.jsp");
                                            }
                                        }
                                    } else {
                                        rd = req.getRequestDispatcher("profile.jsp");
                                    }
                                } else {
                                    rd = req.getRequestDispatcher("profile.jsp");
                                }
                            } else {
                                rd = req.getRequestDispatcher("profile.jsp");
                            }
                        } else {
                            rd = req.getRequestDispatcher("profile.jsp");
                        }
                    } else {
                        rd = req.getRequestDispatcher("profile.jsp");
                    }
                } else {
                    rd = req.getRequestDispatcher("profile.jsp");
                }
            } else {
                rd = req.getRequestDispatcher("profile.jsp");
            }
        } else {
            rd = req.getRequestDispatcher("/timeline");
        }

        System.out.println("test");
        rd.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
