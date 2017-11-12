<%@ page import="com.example.domain.Student" %><%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/11/12
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<%
    Student student = (Student) request.getAttribute("student");
%>
<html>
<head>
    <title>修改学生信息</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/admin/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/admin/Js/bootstrap.js"></script>
</head>
<body>
<form action="${pageContext.request.contextPath}/ModifyStudent" method="post">
    <table class="table table-bordered">
        <tr>
            <th>修改项</th>
            <th>修改内容</th>
        </tr>
        <tr>
            <th>ID</th>
            <td><input type="text" name="studentId"
                       value="<%=student.getStudentId()%>"
                       readonly="readonly"></td>
        </tr>
        <tr>
            <th>姓名</th>
            <td><input type="text" name="studentName"
                       value="<%=student.getName()%>"></td>
        </tr>
        <tr>
            <th>性别</th>
            <%
                String gender = String.valueOf(student.getGender());
                if (gender.equals("男")) {
            %>
            <td><input type="radio" name="studentGender"
                       value="男" checked="checked">男
                <input type="radio" name="studentGender"
                       value="女">女
            </td>
            <%
            } else {
            %>
            <td><input type="radio" name="studentGender"
                       value="男">男
                <input type="radio" name="studentGender"
                       value="女" checked="checked">女
            </td>
            <%
                }
            %>
        </tr>
        <tr>
            <th>年龄</th>
            <td><input type="text" name="studentAge"
                       value="<%=student.getAge()%>"></td>
        </tr>
        <tr>
            <th>学院</th>
            <td><input type="text" name="studentCollege"
                       value="<%=student.getCollege()%>">
            </td>
        </tr>
        <tr>
            <th>专业</th>
            <td><input type="text" name="studentMajor"
                       value="<%=student.getMajor()%>"></td>
        </tr>
        <tr>
            <th>班级</th>
            <td><input type="text" name="studentClass"
                       value="<%=student.getStudentClass()%>">
            </td>
        </tr>
        <tr>
            <th>入学年份</th>
            <td><input type="text"
                       name="studentAdmissionDate"
                       value="<%=student.getAdmissionDate()%>">
            </td>
        </tr>
        <tr>
            <th>联系方式</th>
            <td><input type="text" name="studentPhone"
                       value="<%=student.getPhone()%>"></td>
        </tr>
        <tr>
            <th>家庭住址</th>
            <td><input type="text" name="studentAddress"
                       value="<%=student.getAddress()%>">
            </td>
        </tr>
        <tr>
            <th>宿舍</th>
            <td><input type="text" name="studentDormitory" value="<%=student.getDormitory()%>"></td>
        </tr>
        <tr>
            <th>提交
            </th>
            <td><input type="submit" value="修改"></td>
        </tr>
    </table>
</form>
</body>
</html>
