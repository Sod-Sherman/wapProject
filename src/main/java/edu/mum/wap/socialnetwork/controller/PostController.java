package edu.mum.wap.socialnetwork.controller;

import edu.mum.wap.socialnetwork.model.Post;
import edu.mum.wap.socialnetwork.model.User;
import edu.mum.wap.socialnetwork.service.UserService;
import edu.mum.wap.socialnetwork.service.impl.UserServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;


@WebServlet("/post")
public class PostController extends HttpServlet {

    private boolean isMultipart;
    private String filePath;
    private int maxFileSize = 50 * 1024;
    private int maxMemSize = 4 * 1024;
    private File file;

    public void init() {
        // Get the file location where it would be stored.
        filePath = getServletContext().getInitParameter("file-upload");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        System.out.println("textarea parameter = " + request.getParameter("textarea"));
        System.out.println("CustomField parameter = " + request.getParameter("CustomField"));

        // Check that we have a file upload request
        isMultipart = ServletFileUpload.isMultipartContent(request);
        //response.setContentType("text/html");

        if (!isMultipart) {
            request.setAttribute("status", "Error");
            return;
        }

        DiskFileItemFactory factory = new DiskFileItemFactory();

        // maximum size that will be stored in memory
        factory.setSizeThreshold(maxMemSize);

        // Location to save data that is larger than maxMemSize.
        factory.setRepository(new File("c:\\temp"));

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);

        // maximum file size to be uploaded.
        upload.setSizeMax(maxFileSize);
        String textarea = "";

        try {
            // Parse the request to get file items.
            List fileItems = upload.parseRequest(request);
            if (fileItems != null) {


                // Process the uploaded file items
                Iterator i = fileItems.iterator();

                while (i.hasNext()) {

                    FileItem fi = (FileItem) i.next();

                    if (!fi.isFormField()) {
                        // Get the uploaded file parameters
                        String fieldName = fi.getFieldName();
                        String fileName = fi.getName();
                        String contentType = fi.getContentType();
                        boolean isInMemory = fi.isInMemory();
                        long sizeInBytes = fi.getSize();

                        if(fieldName.equalsIgnoreCase("textarea"))
                            textarea = fi.getString();
                        System.out.println("fi = " + fi);
                        System.out.println("text = = "+textarea);
                       // System.out.println("sizeInBytes = " + sizeInBytes);



                        // Write the file
                        if (fileName.lastIndexOf("\\") >= 0) {
                            file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\")));
                        } else {
                            file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\") + 1));
                        }
                        fi.write(file);
                    }
                }
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }

        String content = textarea; //request.getParameter("textarea");
        User user = (User) request.getSession().getAttribute("loggedInUser");
        UserService userService = new UserServiceImpl();

        String imgUrl = (file == null) ? "" : "images/post/" + file.getName();
        Post newPost = new Post(content, imgUrl, user);
        userService.addPost(user, newPost);
        System.out.println(newPost+"\n"+user);
        response.sendRedirect("timeline");

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {

        throw new ServletException("GET method used with " +
                getClass().getName() + ": POST method required.");
    }
}

