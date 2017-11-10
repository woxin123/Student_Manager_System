<%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/11/2
  Time: 22:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="css/login.css"
          type="text/css">
</head>
<body>
<div id="login_frame">
    <form action="${pageContext.request.contextPath}/Login" method="post">
        <label class="label_input">用户名</label>
        <input type="text" name="username"
               class="text_field"><br/>
        <label class="label_input">密码</label>
        <input type="password" name="password"
               class="text_field"><br/>
        <input type="radio" name="type" value="学生"
               checked="checked">学生&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="radio" name="type" value="老师">老师&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="radio" name="type" value="管理员">管理员&nbsp;&nbsp;&nbsp;&nbsp;<br/>
        <div id="login_control">
            <input id="btn_login" type="submit" value="登录"/>
            <a id="forget_pwd" href="http://www.baidu.com">忘记密码</a>
        </div>
    </form>
    <p id="error">${errors.username}${errors.password}</p>
</div>
</body>
</html>
