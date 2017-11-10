<%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/11/10
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>查找班级</title>
    <link rel="stylesheet" href="<%=path%>/admin/css/bootstrap.min.css">
    <script src="<%=path%>/admin/Js/bootstrap.js"></script>
</head>
<body>
<form role="form" action="${pageContext.request.contextPath}/FindClass" method="post">
    <div class="form-group">
        <label>请选择查询方式</label>
        <select class="form-control" name="type">
            <option>ID</option>
            <option>名称</option>
            <option>学院</option>
            <option>专业</option>
            <option>创建时间</option>
        </select>
        <label>请输入查询的条件</label>
        <input type="text" name="role">
        <input type="submit" value="查找">
    </div>
</form>
</body>
</html>
