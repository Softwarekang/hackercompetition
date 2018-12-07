<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html>
<html>
<head>
    <title>失物招领</title>
    <meta charset="utf-8">
</head>
<link rel="stylesheet" href="<%=basePath%>/static/css/main.css">
<body background="<%=basePath%>/image/main/background.jpg">
<div class="top">
    <img  class="logo" src="<%=basePath%>/image/main/logo.jpg">
    <div class="navigation">
        <input type="button" class="but1"  value="信息发布" onclick="window.location.href='/article/upFile.action?id=${userId}'">
        <input type="button" class="but2"  value="个人主页" onclick="window.location.href='/user/toUserMainPage.action?id=${userId}'">
        <input type="button" class="but3"  value="建议/反馈" onclick="window.location.href='/user/toFeedBack.action?id=${userId}'">
        <input type="button" class="but4"  value="退出登录" onclick="window.location.href='/user/login.action'">
    </div>
</div>
<div class="middle">
    <div class="middle-pic"><img src="<%%>/image/main/@xupt.png"></div>
    <div class="searchfun">
        <form method="post" action="<%=basePath%>/article/search.action?id=${userId}">
            <input class="search" type="text" name="rContent"/>
            <input type="image"  src="<%=basePath%>/image/main/serach.jpg"width=45px; height=45x;>
            <input type="submit" value="查询">
        </form>
    </div></div>
</div>
<div class="container">'
    <div class="left">
        <div class="all">
            <p>全部分类</p></div>
        <div class="classfy">
            <ul>
                <li class="nav_item"><img src="<%=basePath%>/image/main/card.png">&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/article/sort.action?r_sort=card&id=${userId}">一卡通</a> </li>
                <li class="nav_item"><img src="<%=basePath%>/image/main/phone.png">&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/article/sort.action?r_sort=phone&id=${userId}">手机</a> </li>
                <li class="nav_item"><img src="<%=basePath%>/image/main/key.png">&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/article/sort.action?r_sort=key&id=${userId}">钥匙</a> </li>
                <li class="nav_item"><img src="<%=basePath%>/image/main/others.png">&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/article/sort.action?r_sort=others&id=${userId}">其他</a> </li>
            </ul>
        </div>
    </div>
    <div class="right">
        <div class="center_img" ><img width="90%" height="150px" src="<%=basePath%>/image/main/lost_find.png">
        </div>
        <c:forEach items="${articleList}" var="article">
            <div class="informtion">
                <div class="img">
                    <img src="<%=basePath%>${article.rImage}" width="140px" height="182px">
                </div>

                <div class="text">
                    &nbsp;&nbsp;&nbsp;${article.rContent}
                </div>
                    <%--这里注意传id--%>
                <div class="center_btn">
                    <div class="time"><span class="timeout"> 发布时间：${article.rDate}</span></div>
                    <div class="person"><span class="personer">&nbsp;&nbsp; 发布人：${article.rAuthor}</span></div>&nbsp;&nbsp;
                    <a href="/article/show.action?rId=${article.rId}&id=${userId}" class="butn1">查看详情
                    </a>
                    <a href="#" class="butn2"></a>
                </div>
            </div>
        </c:forEach>
    </div>
        <div class="footer">
        </div>
</div>
</body>
</html>