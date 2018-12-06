<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
    // System.out.println(basePath);
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>文件上传</title>
</head>
<link rel="stylesheet" href="<%=basePath%>/static/css/upFile.css"/>
<body>
<div class="header"><img src="<%=basePath%>/image/upFile/upImage.png" alt="发布信息"></div>
<div class="container">
    <form action="${pageContext.request.contextPath}/article/upload.action?id=${user.userId}" enctype="multipart/form-data" method="post">
    <p><span>发布人：<input type="text" name="author" value="${user.userName}" style="width: 200px"></span></p>
    <p><span>物品类型：
            <tr>
                <td>
                    <select name="type" style="width: 200px">
                        <option value="xz" selected>--请选择--</option>
                        <option value="card">一卡通</option>
                        <option value="phone">手机</option>
                        <option value="key">钥匙</option>
                        <option value="thing">其他</option>
                    </select>
                </td>
            </tr>
        </span></p>
    <p><span style="vertical-align: top">描述：<input type="text" name="description" style="vertical-align: top;width: 500px;height: 60px;" placeholder="请尽可能的详细描述您捡到的物品哦~"></span></p>
    <p><span>请选择文件：<input type="file" name="file"></span><span><input type="submit" value="上传"></span></p>
    <p></p>
    </form>
</div>

</body>
</html>
