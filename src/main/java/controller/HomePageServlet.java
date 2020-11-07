package controller;

import model.Post;
import model.User;
import service.PostService;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "homepage",urlPatterns = "/home")
public class HomePageServlet extends HttpServlet {
    UserService userService = new UserService();
    PostService postService = new PostService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "post" :
                postStatus(req,resp);
                break;
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            default :
                showHomePage(req,resp);
                break;
        }
    }

    private void showHomePage(HttpServletRequest req, HttpServletResponse resp) {
        String username =  req.getParameter("username");
        String password =  req.getParameter("password");

        User user = userService.getUserFromUserName(username);
        AppUtils.storeLoginedUser(req.getSession(),user);

        boolean check = userService.checkLogin(username,password);
        RequestDispatcher rs;
        if (check) {
            req.setAttribute("check", "Dang nhap thanh cong");
            rs = req.getRequestDispatcher("page/homepage.jsp");
        }else {
            req.setAttribute("check", "Dang nhap that bai. Hay kiem tra lai");
            rs = req.getRequestDispatcher("login/login.jsp");
        }
        try {
            rs.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    
    private void postStatus(HttpServletRequest req, HttpServletResponse resp) {
        String postContent = req.getParameter("postContent");
        String imagePost = req.getParameter("imagePost");
        LocalDateTime localDateTime = java.time.LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        String formattedDateTime = localDateTime.format(formatter);
        User user =  AppUtils.getLoginedUser(req.getSession());
        Post post = new Post(imagePost,postContent,localDateTime);
        boolean check = postService.insertPost(post,user.getIdUser());
        RequestDispatcher rs;
        req.setAttribute("postContent",postContent);
        req.setAttribute("imagePost","page/images/resources/" + imagePost);
        req.setAttribute("date",formattedDateTime);
        req.setAttribute("user",user.getName());
        req.setAttribute("avatar",user.getAvatar());
        req.setAttribute("show","");
        if (check){
            rs = req.getRequestDispatcher("page/homepage.jsp");
            try {
                rs.forward(req, resp);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }

}
