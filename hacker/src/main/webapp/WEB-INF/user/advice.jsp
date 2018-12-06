<%--
  Created by IntelliJ IDEA.
  User: 安康
  Date: 2018/12/4
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="v-on" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<html>
<link rel="stylesheet" href="<%=basePath%>/static/js/advice.js">
<link rel="stylesheet" href="<%=basePath%>/static/css/advice.css">
<head>
    <title>意见与反馈</title>
</head>
<body>
<div class="header">
    <img src="<%=basePath%>/image/advice/advice.png" alt="意见建议">
</div>
<div class="container" id="box">
    <p><span>发布人： <input type="text" name="username"  value="${user.userName}" placeholder="请输入用户名" style="width: 380px; "/> </span></p>
    <form role="form" action="${pageContext.request.contextPath}/user/postFeedback.action?id=${user.userId}" method="post">
        <div class="form-group">
            <label for="aivice">反馈内容：</label>
            <textarea name="advice" id="advice" cols="60" rows="20" style="vertical-align: top" placeholder="畅所欲言，有问题一定要提出来哦~"></textarea>
        </div>
        <div class="form-group" >
            <input type="submit" value="提交" class="btn btn-primary"  v-on:v-on:click="submit">
            <input type="reset" value="重置" class="btn btn-danger">
        </div>
    </form>
</div>
</body>
</html>
