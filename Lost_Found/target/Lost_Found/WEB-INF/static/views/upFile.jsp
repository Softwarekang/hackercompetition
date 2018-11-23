<%--
  Created by IntelliJ IDEA.
  User: 安康
  Date: 2018/11/22
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>信息上传</title>
</head>
<body>
<form action="upImages" method="post" enctype="multipart/form-data">
    选择图片:<input type="file" name="image"/> <br>
    <input type="submit" value="上传">
</form>

</body>
</html>
