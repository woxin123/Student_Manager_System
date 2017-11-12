<%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/11/12
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<%
    response.sendRedirect(request.getContextPath() + "/login.jsp");
%>
</body>
</html>
