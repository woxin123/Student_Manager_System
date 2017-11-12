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
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/login.css">
    <script src="${pageContext.request.contextPath}/Js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/Js/jquery-3.2.1.min.js"></script>
    <script>
        function reload() {
            var time = new Date().getTime();
            document.getElementById("verification").src = "<%= request.getContextPath()%>/ImageServlet?d=" + time;
        }
    </script>
</head>
<body>

<form action="${pageContext.request.contextPath}/Login"
      method="post">
    <div class="mycenter">
        <div class="mysign">
            <div class="col-lg-11 text-center text-info">
                <h2>登录</h2>
            </div>
            <div class="col-lg-10">
                <input type="text" class="form-control"
                       name="username"
                       placeholder="请输入账号" required
                       autofocus>
            </div>
            <div class="col-lg-10">

            </div>
            <div class="col-lg-10">
                <input type="password"
                       class="form-control"
                       name="password"
                       placeholder="请输入密码" required
                       autofocus>
            </div>
            <div class="col-lg-10">
                <input type="radio" name="type" value="学生"
                       checked="checked"><span class="type">学生</span>
                <input type="radio" name="type" value="老师"><span class="type">老师</span>
                <input type="radio" name="type" value="管理员"><span class="type">管理员</span>
            </div>
            <div class="col-lg-10">
                <span style="font-size: 5px;margin-left: 35px">验证码：</span>
                <input class="myinput" type="text"
                       name="verification" style="width: 100px;height: 20px;margin-left: -5px">
                <img alt="验证码" id="verification" style="margin-left: -20px"
                     src="<%=request.getContextPath()%>/ImageServlet"/>
                <a href="javascript:reload();"><span
                        class="verification">看不清楚</span></a>
            </div>
            <div class="col-lg-10"></div>
            <div class="col-lg-7">
                <button type="submit"
                        class="button btn btn-success col-lg-12 ">登录
                </button>
            </div>
        </div>
    </div>
</form>
<p id="error">${errors.username}${errors.password}</p>

</body>
</html>
