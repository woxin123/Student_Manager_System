<%@ page import="com.example.domain.MyClass" %><%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/11/10
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<%
    String path = request.getContextPath();
    MyClass myClass = (MyClass) request.getAttribute("MyClass");
%>
<html>
<head>
    <title>修改班级信息</title>
    <link rel="stylesheet" href="<%=path%>/admin/css/bootstrap.min.css">
    <script src="<%=path%>/admin/Js/bootstrap.js"></script>
</head>
<body>
<form action="/ModifyClass" method="post">
    <table class="table table-bordered">
        <thead>
        <tr>
            <td>修改项</td>
            <td>修改内容</td>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th>classId</th>
            <td><input type="text" name="classId" value="<%=myClass.getClassId()%>" readonly="readonly"></td>
        </tr>
        <tr>
            <th>名称</th>
            <td><input type="text" name="className" value="<%=myClass.getClassName()%>"></td>
        </tr>
        <tr>
            <th>所在学院</th>
            <td><input type="text" name="classCollege" value="<%=myClass.getClassCollege()%>"></td>
        </tr>
        <tr>
            <th>所在专业</th>
            <td><input type="text" name="classMajor" value="<%=myClass.getClassMajor()%>"></td>
        </tr>
        <tr>
            <th>创建时间</th>
            <td><input type="text" name="classTime" value="<%=myClass.getTime()%>"></td>
        </tr>
        <tr>
            <td><input type="submit" value="修改"></td>
        </tr>
        </tbody>
    </table>
</form>
</body>
</html>
