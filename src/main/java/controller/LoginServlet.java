package controller;

import model.User;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

@WebServlet(name = "login",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        if ("register".equals(action)) {
            showRegisterFrom(req, resp);
        } else {
            showLoginForm(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            checkRegister(req,resp);
    }

    private void showLoginForm(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("login/login.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showRegisterFrom(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher rs = req.getRequestDispatcher("login/register.jsp");
        try {
            rs.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    private void checkRegister(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String avatarCover = "https://www.uplevo.com/img/designbox/anh-bia-facebook-dep-troi-sao.jpg";
        String avatar = "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTnsVMzQHlQUXlv2_aOooeisW78wrSnSLdujQ&usqp=CAU";

        boolean checkUserName = userService.checkUserName(username);
        if (!checkUserName){
            req.setAttribute("checkUserName", "Ten dang nhap da ton tai");
        }else {
            try {
                boolean checkRegister = userService.insertUser(new User( name,username, password, avatarCover, avatar));
                if(checkRegister){
                    req.setAttribute("checkUserName", "Tao tai khoan thanh cong");
                }else {
                    req.setAttribute("checkUserName", "Tao tai khoan that bai");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        RequestDispatcher rs = req.getRequestDispatcher("login/register.jsp");
        try {
            rs.forward(req,resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

}
