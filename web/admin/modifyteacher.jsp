<%@ page import="com.example.domain.Teacher" %><%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/11/9
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
    Teacher teacher = (Teacher) request.getAttribute("teacher");
    String path = request.getContextPath();
%>
<html>
<head>
    <title>修改老师信息</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <link rel="stylesheet" href="<%=path%>/admin/css/bootstrap.min.css">
    <script src="<%=path%>/admin/Js/bootstrap.js"></script>
</head>
<body>
<form action="/ModifyTeacher" method="post">
<table class="table table-bordered">

    <tr>
        <th>修改项</th>
        <th>修改信息</th>
    </tr>
    <tr>
        <td>ID</td>
        <td><input type="text" name="teacherId" value="<%=teacher.getTeacherId()%>" readonly="readonly"></td>
    </tr>
    <tr>
        <td>姓名</td>
        <td><input type="text" name="teacherName" value="<%=teacher.getName()%>"></td>
    </tr>
    <tr>
        <td>年龄</td>
        <td><input type="text" name="teacherAge" value="<%=teacher.getAge()%>"></td>
    </tr>
    <tr>
        <td>性别</td>
        <td>
            <%
                String gender = String.valueOf(teacher.getGender());
                if (gender.equals("男")) {
            %>
            <input type="radio" name="teacherGender" value="男" checked="checked">
            <input type="radio" name="teacherGender" value="女">
            <%
                } else {
            %>
            <input type="radio" name="teacherGender" value="男" >
            <input type="radio" name="teacherGender" value="女" checked="checked">
            <%
                }
            %>
        </td>
    </tr>
    <tr>
        <td>学院</td>
        <td><input type="text" name="teacherCollege" value="<%=teacher.getCollege()%>"></td>
    </tr>
    <tr>
        <td>联系电话</td>
        <td><input type="text" name="teacherPhone" value="<%=teacher.getPhone()%>"></td>
    </tr>
    <tr>
        <td>个人简介</td>
        <td><input type="text" name="teacherIntroduce" value="<%=teacher.getIntroduce()%>"></td>
    </tr>
    <tr>
        <td><input type="submit" value="修改"></td>
    </tr>
</table>
</form>
</body>
</html>
