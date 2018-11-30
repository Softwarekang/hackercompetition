<%--
  Created by IntelliJ IDEA.
  User: 安康
  Date: 2018/11/23
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page isELIgnored="false" %>
<%
    String path = request.getAttribute("imageUrl").toString();

%>
<html>
<head>
    <title>照片回显</title>
</head>
<body>
<img src="<%=path%>" width="200" height="200">
</body>
</html>
