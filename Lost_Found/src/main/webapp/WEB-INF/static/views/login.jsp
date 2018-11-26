<%--
  Created by IntelliJ IDEA.
  User: 安康
  Date: 2018/11/21
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
<div id="login_frame">
    <form method="post" action="/login">
        <p><label class="label_input">用户名</label><input type="text" name="username" class="text_field"/></p>
        <p><label class="label_input">密码</label><input type="password" name="password" class="text_field"/></p>

        <div id="login_control">
            <input type="submit" id="btn_login" value="登录 "/><P id="info">${loginInfo}</P>
            <input type="button" id="zhuce_login" value="注册"/>
            <a id="forget_pwd">忘记密码？</a>
        </div>
    </form>
</div>
</body>
</html>
