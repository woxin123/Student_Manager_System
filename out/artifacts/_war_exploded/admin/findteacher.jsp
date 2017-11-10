<%@ page import="com.example.dao.ManagerTeacher" %>
<%@ page import="com.example.daoImp.ManagerTeacherImpl" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/11/4
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<html>
<head>
    <title>查找老师</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="Js/bootstrap.js"></script>
</head>
<body>
<form action="./resultfindTeacher.jsp" role="form">
    <div class="form-group">
        <label>请选择查询方式</label>
        <select class="form-control" name="type">
            <option>ID</option>
            <option>姓名</option>
        </select>
    </div>
    <div>
        <label>请输入查询条件</label>
        <input type="text" name="role">
        <input type="submit" value="提交">
    </div>
</form>
</body>
</html>
