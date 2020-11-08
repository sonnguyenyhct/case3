package controller;

import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/friendspage")
public class FriendPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        showFriendPage(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    private void showFriendPage(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher rs = req.getRequestDispatcher("/page/friendspage.jsp");
        User user = AppUtils.getLoginedUser(req.getSession());
        req.setAttribute("user",user);
        req.setAttribute("userName",user.getName());
        req.setAttribute("avatar",user.getAvatar());
        try {
            rs.forward(req,resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
