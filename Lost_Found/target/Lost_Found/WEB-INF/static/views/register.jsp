<%--
  Created by IntelliJ IDEA.
  User: 安康
  Date: 2018/11/21
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册界面</title>
</head>
<body>
<h1>欢迎进入注册网页</h1>
<div id="registerInfo">
    <%//out.write(request.getAttribute("registerInfo")==null?"":request.getAttribute("registerInfo").toString());%>
</div>

<div id="login_frame">
    <p id="image_logo"></p>
    <form method="post" action="/register">
        <p><label class="label_input">用户名</label><input type="text" name="username" class="text_field"/></p>
        <p><label class="label_input">密码</label><input type="password" name="password" class="text_field"/></p>
        <p><label class="label_input">确认密码</label><input type="password" name="password01" class="text_field"/></p>
        <p><label class="label_input">邮箱</label><input type="text" name="email" class="text_field"/></p>
        <div id="login_control">
            <input type="submit" id="btn_login" value="确定注册 "/>
        </div>
    </form>
</div>
</body>

</html>
