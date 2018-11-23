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
        <p><label class="label_input">用户名</label><input type="text" name="username" id="username" onblur="ajax()" class="text_field" /><span id="info"></span></p>
        <p><label class="label_input">密码</label><input type="password" name="password" class="text_field"/></p>
        <p><label class="label_input">确认密码</label><input type="password" name="password01" class="text_field"/></p>
        <p><label class="label_input">邮箱</label><input type="text" name="email" class="text_field"/></p>
        <div id="login_control">
            <input type="submit" id="btn_login" value="确定注册 "/>
        </div>
    </form>
</div>
</body>

<script type="text/javascript">
    function ajax() {
      //  获得输入框的username值
      var username=document.getElementById('username').value;
      // 创建ajax引擎对象
      var xmlHttp = new XMLHttpRequest();
      // post方法
      xmlHttp.open("post","/ajax",true);
      xmlHttp.setRequestHeader('content-type','application/x-www-form-urlencoded');
      xmlHttp.send('username='+username);
      xmlHttp.onreadystatechange=function () {
        if((xmlHttp.status == 200) && (xmlHttp.readyState == 4)) {
          var info = xmlHttp.responseText;
          if(info == 'yes'){
            document.getElementById('info').innerHTML="用户已经存在";
          }else{
            document.getElementById('info').innerHTML="可以注册此用户名";
          }
        }
      };
    }
</script>
</html>
