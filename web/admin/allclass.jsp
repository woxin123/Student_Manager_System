<%@ page import="com.example.domain.MyClass" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/11/10
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<%
    String path = request.getContextPath();
    List<MyClass> allClass = (List<MyClass>) request.getAttribute("allClass");
%>
<html>
<head>
    <title>班级列表</title>
    <link rel="stylesheet" href="<%=path%>/admin/css/bootstrap.min.css">
    <script src="<%=path%>/admin/Js/bootstrap.js"></script>
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
<%
    if (allClass.size() == 0) {
        out.println("没有班级信息");
    } else {
%>
<table class="table table-bordered">
    <thead>
    <tr>
        <th>classId</th>
        <th>名称</th>
        <th>所在学院</th>
        <th>所在专业</th>
        <th>创建时间</th>
        <th>总人数</th>
        <th>修改</th>
        <th>删除</th>
    </tr>
    </thead>
    <tbody>
    <%
        for (MyClass myclass : allClass) {
    %>
    <tr>
        <td><%=myclass.getClassId()%>
        </td>
        <td><%=myclass.getClassName()%>
        </td>
        <td><%=myclass.getClassCollege()%>
        </td>
        <td><%=myclass.getClassMajor()%>
        </td>
        <td><%=myclass.getTime()%>
        </td>
        <td><%=myclass.getTotal()%>
        </td>
        <td><a href="GetModifyClassMessage?classId=<%=myclass.getClassId()%>"><button onclick="javascript:return modifyClass()">修改</button> </a></td>
        <td><a href="DeleteClass?classId=<%=myclass.getClassId()%>">
            <button onclick="javascript:return deleteClass()">删除</button></a> </td>
    </tr>
    <%
            }
        }
    %>
    </tbody>
</table>
</body>
</html>
