<%--
  Created by IntelliJ IDEA.
  User: 侯景瀚
  Date: 2018/12/2
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${searchList}" var="article">
    <div class="right">
        <div class="center_img" ><img  width="90%" height="150px" src="失物招领.png">
        </div>
        <div class="informtion">
            <div class="img">这是一个失物图片
                <img src="${article.rImage}">
            </div>
            <div class="text">
                    ${article.rContent}
            </div>
                <%--这里注意传id--%>
            <div class="center_btn">
                <a href="${pageContext.request.contextPath}/article/show.action" class="butn1">查看详情
                </a>&nbsp;&nbsp;
                <a href="#" class="butn2">回复</a>
            </div>
        </div>

    </div>
</c:forEach>
</body>
</html>
