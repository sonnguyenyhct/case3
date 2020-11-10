package controller;

import model.Post;
import model.User;
import service.FriendService;
import service.PostService;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@WebServlet(urlPatterns = "/personalpage")
public class PersonalPageServlet extends HttpServlet {
    UserService userService = new UserService();
    PostService postService = new PostService();
    List<Post> postList = new ArrayList<>();
    FriendService friendService = new FriendService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int action = Integer.parseInt(req.getParameter("action"));
        String avatarEdit = req.getParameter("avatarEdit");
        String editCoverPhoto = req.getParameter("editCoverPhoto");
        int check = AppUtils.getLoginedUser(req.getSession()).getIdUser();
        if (check == action){
            showPersonalPage(req,resp);
        }else {
            User user = userService.selectUser(action);
            postList = postService.selectAllPostPersonal(action);
            req.setAttribute("user",user);
            req.setAttribute("userName",user.getName());
            req.setAttribute("avatar",user.getAvatar());
            req.setAttribute("postList",postList);
            RequestDispatcher rs = req.getRequestDispatcher("page/viewfriendpage.jsp");
            try {
                rs.forward(req,resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
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
        addFriend(req,resp);
        showViewFriend(req,resp);
    }

    private void showPersonalPage(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher rs = req.getRequestDispatcher("page/personalpage.jsp");
        int idUser = AppUtils.getLoginedUser(req.getSession()).getIdUser();
        postList = postService.selectAllPostPersonal(idUser);

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
    private void addFriend(HttpServletRequest req, HttpServletResponse resp) {
        int idFriend = Integer.parseInt(req.getParameter("action"));
        int idUser = AppUtils.getLoginedUser(req.getSession()).getIdUser();
        try {
            friendService.makeFriend(idFriend,idUser);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    private void showViewFriend(HttpServletRequest req, HttpServletResponse resp) {
        int action = Integer.parseInt(req.getParameter("action"));
        User user = userService.selectUser(action);
        postList = postService.selectAllPostPersonal(action);
        req.setAttribute("user",user);
        req.setAttribute("userName",user.getName());
        req.setAttribute("avatar",user.getAvatar());
        req.setAttribute("postList",postList);
        RequestDispatcher rs = req.getRequestDispatcher("page/viewfriendpage.jsp");
        try {
            rs.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}