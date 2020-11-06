<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 11/5/2020
  Time: 3:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form name="hello" method="post" >
        <input name="username" placeholder="username">
        <input name="password" placeholder="password">
        <input type="submit" value="Đăng nhập">
    </form>
    <p>
        <span class="check">${requestScope["check"]}</span>
    </p>
</body>
</html>
