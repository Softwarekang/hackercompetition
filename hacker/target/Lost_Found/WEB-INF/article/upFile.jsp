<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>文件上传</title>

</head>
<body>
<h2>文件上传</h2>
<form action="/article/upload.action" enctype="multipart/form-data" method="post">
    <table>
        <tr>
            <td>作者名称:</td>
            <td><input type="text" name="author"></td>
        </tr>
        <tr>
            <td>物品类型:</td>
            <td><input type="text" name="type"></td>
        </tr>
        <tr>
            <td>描述：</td>
            <td><input type="text" name="description"> </td>
        </tr>
        <tr>
            <td>请选择文件:</td>
            <td><input type="file" name="file"></td>
        </tr>
        <tr>
            <td><input type="submit" value="上传"></td>
        </tr>
    </table>
</form>
</body>
</html>
