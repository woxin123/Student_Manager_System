<%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/11/8
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<html>
<head>
    <title>添加班级</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="Js/bootstrap.js"></script>
</head>
<body>
<form action="${pageContext.request.contextPath}/AddClass" method="post" role="form">
    <div class="form-group" style="margin-left: 40px">
        <label>classId</label>
        <div class="col-sm-10">
            <input type="text" name="classId"
                   placeholder="请输入班级ID">
        </div>
        <label>班级名称</label>
        <div class="col-sm-10">
            <input type="text" name="className"
                   placeholder="请输入班级名称">
        </div>
        <label>学院</label>${errors.studentAge}
        <div class="col-sm-10">
            <input type="text" name="classCollege"
                   placeholder="请输入班级所在的学院">
        </div>
        <label>专业</label>
        <div class="col-sm-10">
            <input type="text" name="classMajor"
                   placeholder="请输入班级所在的专业">
        </div>
        <label>创建年份</label>
        <div class="col-sm-10">
            <input type="text" name="classTime"
                   placeholder="请输入班级班级创建的年份">
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">添加</button>
            </div>
        </div>
</form>
</body>
</html>
