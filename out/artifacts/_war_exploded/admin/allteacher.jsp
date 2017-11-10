<%@ page import="com.example.dao.ManagerTeacher" %>
<%@ page import="com.example.daoImp.ManagerTeacherImpl" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/11/3
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
    ManagerTeacher manTea = new ManagerTeacherImpl();
    ResultSet rs = manTea.findAllTeacher();
    String path = request.getContextPath();
%>
<html>
<head>
    <title>所有老师</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <link rel="stylesheet" href="<%=path%>/admin/css/bootstrap.min.css">
    <script src="<%=path%>/admin/Js/bootstrap.js"></script>
    <script>
        function deleteTeacher() {
            var msg="是否删除";
            if (confirm(msg) == true)
                return true;
            else
                return false;
        };
        function modifyTeacher() {
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
        <th>学院</th>
        <th>联系电话</th>
        <th>个人简介</th>
        <th>修改信息</th>
        <th>删除</th>
    </tr>
    </thead>
    <%
        if (rs == null) {
            out.println("没有老师");
        } else {
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
        <td><a href="/GetTeacherMessage?teacherId=<%=rs.getString(1)%>">
            <button onclick="javascript:return modifyTeacher()">修改</button></a></td>
        <td><a href="/DeleteTeacher?teacherId=<%=rs.getString(1)%>">
            <button onclick="javascript:return deleteTeacher()">删除</button></a></td>
    </tr>
    <%
            }
        }
    %>
    </tbody>
</table>

</body>
</html>
