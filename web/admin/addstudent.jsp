<%@ page import="com.example.domain.Student" %><%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/11/6
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>添加学生</title>
    <link rel="stylesheet"
          href="<%=path%>/admin/css/bootstrap.min.css">
    <script src="<%=path%>/admin/Js/bootstrap.js"></script>
</head>
<body>
<form role="form"
      action="${pageContext.request.contextPath}/AddStudent"
      method="post">
    <table class="table table-bordered">
        <tr>
            <th>ID</th>
            <td><input type="text" name="studentId"
                       value="${student.studentId}">
                <span style="color: red;">${errors.studentId}</span>
            </td>
        </tr>
        <tr>
            <th>姓名</th>
            <td><input type="text" name="studentName"
                       value="${student.name}">
                <span style="color: red;">${errors.studentName}</span>
            </td>
        </tr>
        <tr>
            <th>性别</th>
            <td><input type="radio" name="studentGender"
                       value="男" checked="checked">男
                <input type="radio" name="studentGender"
                       value="女">女
            </td>
        </tr>
        <tr>
            <th>年龄</th>
            <td><input type="text" name="studentAge"
                       value="${student.gender}">
                <span style="color: red;">${errors.studentAge}</span>
            </td>
        </tr>
        <tr>
            <th>学院</th>
            <td><input type="text" name="studentCollege"
                       value="${student.college}">
                <span style="color: red;">${errors.studentCollege}</span>
            </td>
        </tr>
        <tr>
            <th>专业</th>
            <td><input type="text" name="studentMajor"
                       value="${student.major}">
                <span style="color: red;">${errors.studentMajor}</span>
            </td>
        </tr>
        <tr>
            <th>班级</th>
            <td><input type="text" name="studentClass"
                       value="${student.classId}">
                <span style="color: red;">${errors.studentClass}</span>
            </td>
        </tr>
        <tr>
            <th>入学年份</th>
            <td><input type="text"
                       name="studentAdmissionDate"
                       value="${student.admissionDate}">
                <span style="color: red;">${errors.studentAdmissionDate}</span>
            </td>
        </tr>
        <tr>
            <th>联系电话</th>
            <td><input type="text" name="studentPhone"
                       value="${student.phone}">
                <span style="color: red;">${errors.studentPhone}</span>
            </td>
        </tr>
        <tr>
            <th>家庭住址</th>
            <td><input type="text" name="studentAddress"
                       value="${student.address}">
                <span style="color: red;">${errors.studentAddress}</span>
            </td>
        </tr>
        <tr>
            <th>宿舍</th>
            <td><input type="text" name="studentDormitory"
                       value="${student.dormitory}">
                <span style="color: red;">${errors.studentDormitory}</span>
            </td>
        </tr>
        <tr>
            <td><input type="reset" value="重置"></td>
            <td><input type="submit" value="增加"></td>
        </tr>
    </table>
</form>
</body>
</html>
