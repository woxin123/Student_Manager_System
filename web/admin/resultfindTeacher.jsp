<%@ page import="com.example.dao.ManagerTeacher" %>
<%@ page import="com.example.daoImp.ManagerTeacherImpl" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/11/4
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
    ManagerTeacher manTea = new ManagerTeacherImpl();
    String type = request.getParameter("type");
    String role = request.getParameter("role");
    ResultSet rs = manTea.findTeacher(role, type);
%>
<html>
<head>
    <title>老师列表</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="Js/bootstrap.js"></script>
</head>
<body>
<%
    if (rs == null) {
        out.println("没有找到符合条件的老师");
    } else {
%>
<table class="table table-bordered">
    <thead>
    <tr>
        <th>ID</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>学院</th>
        <th>联系电话</th>
        <th>个人简介</th>
    </tr>
    </thead>
    <%
        while (rs.next()) {
    %>
    <tbody>
    <tr>
        <td><%=rs.getString(1)%>
        </td>
        <td><%=rs.getString(2)%>
        </td>
        <td><%=rs.getString(3)%>
        </td>
        <td><%=rs.getInt(4)%>
        </td>
        <td><%=rs.getString(5)%>
        </td>
        <td><%=rs.getString(6)%>
        </td>
        <td><%=rs.getString(7)%>
        </td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
<%
    }
%>
</body>
</html>
