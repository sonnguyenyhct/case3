package controller;

import model.Friend;
import model.User;
import service.FriendService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/friendspage")
public class FriendPageServlet extends HttpServlet {
    FriendService friendService = new FriendService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            showFriendPage(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    private void showFriendPage(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        RequestDispatcher rs = req.getRequestDispatcher("/page/friendspage.jsp");
        User user = AppUtils.getLoginedUser(req.getSession());
        req.setAttribute("user",user);
        req.setAttribute("userName",user.getName());
        req.setAttribute("avatar",user.getAvatar());
        int idUser = AppUtils.getLoginedUser(req.getSession()).getIdUser();
        List<Friend> friendList =  friendService.displayListPending(idUser);

        req.setAttribute("friendList",friendList);
        List<Friend> listAccept = friendService.displayAllFriend(idUser);
        req.setAttribute("listAccept",listAccept);
        rs.forward(req,resp);

    }
}
