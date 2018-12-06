<%--
  Created by IntelliJ IDEA.
  User: 安康
  Date: 2018/12/4
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
    // System.out.println(basePath);
%>
<html>
<link rel="stylesheet" href="<%=basePath%>/static/css/userPage.css">
<head>
    <title>个人主页</title>
</head>
<body>
<div class="header"><img src="<%=basePath%>/image/userInfo/word.png" alt="个人主页"></div>
<div class="container">
    <img src="<%=basePath%>/image/userInfo/head.jpg" alt="头像"/>
    <br/><br/>
    <form>
        <table width="300px" align="center" style="color: orange">
            <tr>
                <td>用户名：</td>
                <td>${user.userName}</td>
            </tr>
            <tr>
                <td>联系方式：</td>
                <td>${user.userEmail}</td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
