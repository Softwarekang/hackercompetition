<%--
  Created by IntelliJ IDEA.
  User: 安康
  Date: 2018/11/27
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>上传成功</title>
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
<h1 >上传成功</h1>
<h2><input type="button" onclick="window.location.href='/article/listAll.action?id=${userId}'" value="点击此处回到主页面"></h2>

</body>
</html>
