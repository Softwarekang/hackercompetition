<%--
  Created by IntelliJ IDEA.
  User: 安康
  Date: 2018/12/4
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>反馈成功界面</title>
</head>
<style type="text/css">
    body{
        background-color: beige;
    }

    h1{
        text-align: center;
    }

    h2{
        text-align: center;
    }
</style>
<body>
<h1>感谢您的反馈</h1>
<h2><input type="button" value="点击此处回到主页面" onclick="window.location.href='/article/listAll.action?id=${userId}'"> </h2>
</body>
</html>