<%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/11/3
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<html>
<head>
    <title>增添老师</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="Js/bootstrap.js"></script>

</head>
<body>
<form role="form" action="/AddTeacher" method="post">
    <div class="form-group">
        <label>ID</label>
        <div class="col-sm-10">
            <input type="number" name="teacherId" placeholder="请输入老师ID">
        </div>
    </div>
    姓名：<input type="text" name="teachername"/><br/>
    性别：<input type="radio" name="gender" value="男"
              checked="checked">男
    <input type="radio" name="gender" value="女">女<br/>
    年龄：<input type="number" name="age"><br/>
    学院：<input type="text" name="college"><br/>
    联系方式：<input type="number" name="phone"><br/>
    简介：<textarea name="introduce">

    </textarea>
    <input type="submit" value="增加"/><br/>
</form>
${message}
</body>
</html>
