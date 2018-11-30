<%--
  Created by IntelliJ IDEA.
  User: 安康
  Date: 2018/11/21
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
    // System.out.println(basePath);
%>
<html>
<head>
<title>注册界面</title>
</head>
<body>
<div id="registerInfo">${registerInfo}</div>
<div class="fause" id="ajaxInfo"></div>
<form action="${pageContext.request.contextPath}/user/register.action" method="post">
    <div  class="insert">注册账号</div>
    <table>
        <tr><td><span>用户名</span></td><td><input type="text" name="userName" id="username" onblur="ajax()"/></td></tr>
        <tr><td><span>密码</span></td><td><input type="password" name="userPassword" /></td></tr>
        <tr><td><span>确认密码</span></td><td><input type="password" name="user_confirm_password" /></td></tr>
        <tr><td>性别</td><td><input type="radio" id="male" name="user_sex" checked />男<input type="radio" id="female" name="user_sex" />女</td></tr>
        <tr><td>邮箱</td><td><input type="text" name="email" /></td></tr>
        <tr><td colspan="2"><input type="checkbox" checked/>我已看过并接受<a href="#">《用户协议》</a></td></tr>
        <tr><td colspan="2"><input type="submit" name="submit" value="立即注册" /></td></tr>
    </table>
</form>
</body>
<link rel="stylesheet" href="<%=basePath%>/static/css/register.css">
<script type="text/javascript">
    function ajax() {
      //  获得输入框的username值
      var username=document.getElementById('username').value;
      // 创建ajax引擎对象
      var xmlHttp = new XMLHttpRequest();
      // post方法
      xmlHttp.open("post","/user/ajax.action",true);
      xmlHttp.setRequestHeader('content-type','application/x-www-form-urlencoded');
      xmlHttp.send('username='+username);
      xmlHttp.onreadystatechange=function () {
        if((xmlHttp.status == 200) && (xmlHttp.readyState == 4)) {
          var info = xmlHttp.responseText;
          if(info == 'yes'){
            document.getElementById('ajaxInfo').innerHTML="用户已经存在";
          }else{
            document.getElementById('ajaxInfo').innerHTML="可以注册此用户名";
          }
        }
      };
    }
</script>
</html>
