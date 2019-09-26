package edu.mum.wap.socialnetwork.controller.sod;

import edu.mum.wap.socialnetwork.model.Post;
import edu.mum.wap.socialnetwork.model.User;
import edu.mum.wap.socialnetwork.service.UserService;
import edu.mum.wap.socialnetwork.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;


@WebServlet("/post")
@MultipartConfig
public class PostController extends HttpServlet {

    private String filePath;
    private final String DEFAULT_FILENAME = "noname";
    private Integer fileNameCounter = 0;

    public void init() {
        // Get the file location where it would be stored.
        filePath = getServletContext().getInitParameter("file-upload");
    }


    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename"))
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
        }
        return DEFAULT_FILENAME + fileNameCounter++ + ".jpg";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {

        String content = request.getParameter("textArea1");
        String imgUrl = "";
        String uploadPath = filePath;
        System.out.println("uploadPath = " + uploadPath);
        String fileName;
        for (Part part : request.getParts()) {
            if (part != null && !getFileName(part).contains(DEFAULT_FILENAME)) {
                fileName = getFileName(part);
                if (!fileName.isEmpty()) {
                    imgUrl = "images/post/" + fileName;
                    part.write(uploadPath + File.separator + fileName);
                }

            }
        }

        User user = (User) request.getSession().getAttribute("loggedInUser");
        UserService userService = new UserServiceImpl();

        Post newPost = new Post(content, imgUrl, user);
        userService.addPost(user, newPost);
        System.out.println(newPost + "\n" + user);

        RequestDispatcher rd = request.getRequestDispatcher("timeline.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

