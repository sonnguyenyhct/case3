package controller;

import service.FriendService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/viewfriend")
public class ViewFriendServlet extends HttpServlet {
    FriendService friendService = new FriendService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            showViewFriend(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        acceptFriend(req,resp);
        showViewFriend(req,resp);
    }

    private void acceptFriend(HttpServletRequest req, HttpServletResponse resp) {
        int idFriend = Integer.parseInt(req.getParameter("action"));
        int idUser = AppUtils.getLoginedUser(req.getSession()).getIdUser();
        try {
            friendService.acceptFriend(idFriend);
            friendService.setAcceptFriendSql(idFriend,idUser);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    private void showViewFriend(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher rs = req.getRequestDispatcher("page/viewfriendpage.jsp");
        try {
            rs.forward(req,resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
