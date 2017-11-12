<%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/11/12
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<html>
<head>
    <title>查找学生</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/admin/css/bootstrap.min.css"></script>
</head>
<body>
<form role="form" action="${pageContext.request.contextPath}/FindStudents" method="post">
    <div class="form-group">
        <label>请选择查询方式</label>
        <select class="form-control" name="type">
            <option>ID</option>
            <option>姓名</option>
            <option>学院</option>
            <option>专业</option>
            <option>班级</option>
            <option>入学年份</option>
            <option>宿舍</option>
        </select>
        <label>请输入查询的条件</label>
        <input type="text" name="role">
        <input type="submit" value="查找">
    </div>
</form>
</body>
</html>
