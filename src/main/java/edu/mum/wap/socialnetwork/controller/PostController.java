package edu.mum.wap.socialnetwork.controller;

import edu.mum.wap.socialnetwork.model.Post;
import edu.mum.wap.socialnetwork.model.User;
import edu.mum.wap.socialnetwork.service.UserService;
import edu.mum.wap.socialnetwork.service.impl.UserServiceImpl;

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

    private boolean isMultipart;
    private String filePath;
    private int maxFileSize = 50 * 1024;
    private int maxMemSize = 4 * 1024;
    private File file;
    private final String DEFAULT_FILENAME = "noname";
    private Integer fileNameCounter = 0;

    public void init() {
        // Get the file location where it would be stored.
        filePath = getServletContext().getInitParameter("file-upload");


    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String content = request.getParameter("textArea1");
        System.out.println("content = " + content);
        String imgUrl = "";
        String UPLOAD_DIRECTORY = filePath;
        String uploadPath = UPLOAD_DIRECTORY;
        System.out.println("uploadPath = " + uploadPath);
        String fileName;
        for (Part part : request.getParts()) {
            fileName = getFileName(part);
            if (!fileName.contains(DEFAULT_FILENAME)) {
                imgUrl = "images/post/" + fileName;
                System.out.println("part = " + part.getSubmittedFileName());
                part.write(uploadPath + File.separator + fileName);
            }
        }

        User user = (User) request.getSession().getAttribute("loggedInUser");
        UserService userService = new UserServiceImpl();

        Post newPost = new Post(content, imgUrl, user);
        userService.addPost(user, newPost);
        System.out.println(newPost + "\n" + user);
        response.sendRedirect("timeline");

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

        throw new ServletException("GET method used with " +
                getClass().getName() + ": POST method required.");
    }
}

