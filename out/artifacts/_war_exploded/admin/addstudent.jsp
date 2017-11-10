<%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/11/6
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<html>
<head>
    <title>添加学生</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="Js/bootstrap.js"></script>
</head>
<body>
<form role="form" action="${pageContext.request.contextPath}/AddStudent" method="post">
    <div class="form-group" style="margin-left: 40px">
        <label>ID&nbsp;&nbsp;&nbsp;${errors.studentId}</label>
        <div class="col-sm-10">
            <input type="text" name="studentId"
                   placeholder="请输入学生ID">
        </div>
        <label>姓名&nbsp;&nbsp;&nbsp;${errors.studentName}</label>
        <div class="col-sm-10">
            <input type="text" name="studentName"
                   placeholder="请输入学生的姓名">
        </div>
        <label>性别</label>&nbsp;&nbsp;&nbsp;&nbsp;
        <label class="radio-inline">
            <input type="radio" name="studentGender"
                   id="optionsRadios3" value="男" checked>男
        </label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <label class="radio-inline">
            <input type="radio" name="studentGender"
                   id="optionsRadios4" value="女">女
        </label><br/>
        <label>年龄</label>${errors.studentAge}
        <div class="col-sm-10">
            <input type="text" name="studentAge"
                   placeholder="请输入学生的年龄">
        </div>
        <label>学院</label>${errors.studentCollege}
        <div class="col-sm-10">
            <input type="text" name="studentCollege"
                   placeholder="请输入学生所在学院">
        </div>
        <label>专业</label>${errors.studentMajor}
        <div class="col-sm-10">
            <input type="text" name="studentMajor"
                   placeholder="请输入学生所在专业">
        </div>
        <label>班级</label>${errors.studentClass}
        <div class="col-sm-10">
            <input type="text" name="classId"
                   placeholder="请输入学生所在班级的Id">
        </div>
        <label>入学时间</label>${errors.admissionDate}
        <div class="col-sm-10">
            <input type="text" name="admissionDate"
                   placeholder="请输入学生入学年份">
        </div>
        <label>联系方式</label>
        <div class="col-sm-10">
            <input type="text" name="phone"
                   placeholder="请输入学生电话">
        </div>
        <label>家庭住址</label>${errors.admissionDate}
        <div class="col-sm-10">
            <input type="text" name="address"
                   placeholder="请输入学生的家庭住址">
        </div>
        <label>所在宿舍</label>${errors.admissionDate}
        <div class="col-sm-10">
            <input type="text" name="dormitory"
                   placeholder="请输入学生所在的宿舍">
        </div>
        <br/><br/>
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">
                提交
            </button>
        </div>
    </div>
</form>
</body>
</html>
