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
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/personalpage")
public class PersonalPageServlet extends HttpServlet {
    UserService userService = new UserService();
    PostService postService = new PostService();
    List<Post> postList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String avatarEdit = req.getParameter("avatarEdit");
        String editCoverPhoto = req.getParameter("editCoverPhoto");
        if (action == null){
            action = "";
        }
        switch (action){
            default:
                showPersonalPage(req,resp);
                break;
        }
        if(avatarEdit != null){
            editPhoto(req,resp);
        }
        if (editCoverPhoto != null){
            editCoverPhoto(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    private void showPersonalPage(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher rs = req.getRequestDispatcher("page/personalpage.jsp");
        postList = postService.selectAllPost();
        User user = AppUtils.getLoginedUser(req.getSession());
        req.setAttribute("user",user);
        req.setAttribute("userName",user.getName());
        req.setAttribute("avatar",user.getAvatar());
        req.setAttribute("postList",postList);
        try {
            rs.forward(req,resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void editPhoto(HttpServletRequest req, HttpServletResponse resp) {
        String avatarNew = req.getParameter("avatarEdit");
        User user = AppUtils.getLoginedUser(req.getSession());
        user.setAvatar("page/images/resources/" + avatarNew);
        userService.updateAvatarUser(user);
        RequestDispatcher rs = req.getRequestDispatcher("page/personalpage.jsp");
        try {
            rs.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    private void editCoverPhoto(HttpServletRequest req, HttpServletResponse resp) {
        String editCoverPhoto = req.getParameter("editCoverPhoto");
        User user = AppUtils.getLoginedUser(req.getSession());
        if (!editCoverPhoto.equals("")){
            user.setAvatarCover("page/images/resources/" + editCoverPhoto);
            userService.updateCoverAvatarUser(user);
            RequestDispatcher rs = req.getRequestDispatcher("page/personalpage.jsp");
            try {
                rs.forward(req, resp);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }


    }
}
