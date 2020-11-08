package controller;

import model.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

public class AppUtils {

    public static void storeLoginedUser(HttpSession session, User loginedUser){
        session.setAttribute("loginedUser",loginedUser);
    }
    // Lấy thông tin người dùng lưu trữ trong Session.
    public static User getLoginedUser(HttpSession session) {
        User loginedUser = (User) session.getAttribute("loginedUser");
        return loginedUser;
    }

    //Huy Session
    public static void deleteLoginedUser(HttpSession session){
        session.removeAttribute("loginedUser");
    }
}
