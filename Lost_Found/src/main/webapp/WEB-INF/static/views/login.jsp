<%--
  Created by IntelliJ IDEA.
  User: 安康
  Date: 2018/11/21
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
    // System.out.println(basePath);
%>
<html>
<head>
    <title>用户登录</title>
</head>
<link rel="stylesheet" href="<%=basePath%>/css/login.css">
<body>
<div id="loginInfo">${loginInfo}</div>
<div class ="header">
    <div class="pic1"><img src="西邮.jpg" height="150px" width="1000px"></div>
</div>
<div  class ="container">
    <div class="left"><img src="css手机1.0.jpg"></div>
    <form class="right"id ="register" method="post"  action="/login">
        用户名：<input id="user"name="username" ><br><br>&nbsp;&nbsp;
        密码：<input name="password" type="password" id="password"><br><br>
        <input class="btn1" type="submit" value="登录" ><br>
        <input class="btn2" type="button" value="注册" onclick="window.location.href='/regis'" ><br>
    </form>
</div>
<div class="footer">
    <div class="one">使用说明：<span class="oner">此网站为西安邮电大学校园内部失物招领网</span></div>
    <div class="two">技术支持：<span class="twoer">EPI-软件部(安康、胡毅、侯景瀚、何利、王静)</span></div>
</div>
</body>
</html>
