<%@ page import="com.example.domain.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/11/11
  Time: 23:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<%
    List<Student> allStudents = (List<Student>) request.getAttribute("allStudents");
%>
<html>
<head>
    <title>所有的学生</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/admin/Js/bootstrap.js"></script>
    <script>
        function deleteClass() {
            var msg="是否删除";
            if (confirm(msg) == true)
                return true;
            else
                return false;
        };
        function modifyClass() {
            var msg="是否修改";
            if (confirm(msg) == true)
                return true;
            else
                return false;
        }
    </script>
</head>
<body>
<table class="table table-bordered">
    <thead>
    <tr>
        <th>ID</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>所在学院</th>
        <th>专业</th>
        <th>班级</th>
        <th>入学年份</th>
        <th>联系方式</th>
        <th>宿舍</th>
        <th>家庭住址</th>
        <th>修改</th>
        <th>删除</th>
    </tr>
    </thead>
    <tbody>
    <%
        for (Student student : allStudents) {
    %>
    <tr>
        <td><%=student.getStudentId()%></td>
        <td><%=student.getName()%></td>
        <td><%=student.getGender()%></td>
        <td><%=student.getAge()%></td>
        <td><%=student.getCollege()%></td>
        <td><%=student.getMajor()%></td>
        <td><%=student.getStudentClass()%></td>
        <td><%=student.getAdmissionDate()%></td>
        <td><%=student.getPhone()%></td>
        <td><%=student.getDormitory()%></td>
        <td><%=student.getAddress()%></td>
        <td><a href="/GetModifyStudentMessage?studentId=<%=student.getStudentId()%>"><button onclick="javascript: return modifyClass()">修改</button></a> </td>
        <td><a href="/DeleteStudent?studentId=<%=student.getStudentId()%>">
            <button onclick="javascript: return deleteClass()" >删除</button></a> </td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>
