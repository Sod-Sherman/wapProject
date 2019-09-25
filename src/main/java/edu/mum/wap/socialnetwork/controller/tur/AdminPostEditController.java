package edu.mum.wap.socialnetwork.controller.tur;

import edu.mum.wap.socialnetwork.model.Post;
import edu.mum.wap.socialnetwork.service.PostService;
import edu.mum.wap.socialnetwork.service.impl.PostServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet({"/post_ban"})
public class AdminPostEditController extends HttpServlet {
    PostService postService = new PostServiceImpl();

    public AdminPostEditController() {
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String page = "";
        try {
            Post tempPost = postService.findPostById(Integer.parseInt(req.getParameter("post_id")));
            if(tempPost.getActive()){
                tempPost.setActive(false);
                System.out.println(tempPost.getActive());
            } else {
                tempPost.setActive(true);
            }

        } catch (Exception e) {
            page = "advertisement.jsp";
        } finally {
            page = "post_list.jsp";
        }
        RequestDispatcher dd=req.getRequestDispatcher("post_list.jsp");
        dd.forward(req, resp);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
