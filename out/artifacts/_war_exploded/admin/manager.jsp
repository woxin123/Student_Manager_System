<%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/11/1
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>管理</title>
    <script src="Js/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/admin.css">
    <link rel="stylesheet" href="css/pintuer.css">
</head>
<body style="background-color: #f2f9fd;">
<div class="header bg-main">
    <div class="logo margin-big-left fadein-top">
        <h1>
            <img src="image/huoying2.jpg"
                 class="radius-circle rotate-hover"
                 height="50">
        </h1>
    </div>
    <div class="head-1">
        <a class="button button-little bg-blue"
           href=""><span class="icon-power-off"></span>退出登录</a>
    </div>
    <div class="leftnav">
        <div class="leftnav-title">
            <strong><span
                    class="icon-list"></span>菜单列表</strong>
        </div>
        <h2>
            <span class="icon-user"></span>基本设置
        </h2>
        <ul style="display: block">
            <li>
                <a href="" target="right"><span
                        class="icon-caret-right">添加管理员</span></a>
            </li>
            <li>
                <a href="" target="right"><span
                        class="icon-caret-right">删除管理员</span></a>
            </li>
            <li>
                <a href="" target="right"><span
                        class="icon-caret-right">修改密码</span></a>
            </li>
        </ul>
        <h2>
            <span class="icon-pencil-square-o"></span>老师管理
        </h2>
        <ul style="display: block">
            <li>
                <a href="./allteacher.jsp" target="right"><span
                        class="icon-caret-right">老师列表</span></a>
            </li>
            <li>
                <a href="./addteacher.jsp"
                   target="right"><span
                        class="icon-caret-right">添加老师</span></a>
            </li>
            <li>
                <a href="./findteacher.jsp" target="right"><span
                        class="icon-caret-right">查找老师</span></a>
            </li>
        </ul>
        <h2>
            <span class="icon-user"></span>班级管理
        </h2>
        <ul style="display: block">
            <li>
                <a href="/AllClass" target="right"><span
                        class="icon-caret-right">班级列表</span></a>
            </li>
            <li>
                <a href="./addclass.jsp" target="right"><span
                        class="icon-caret-right">添加班级</span></a>
            </li>
            <li>
                <a href="./findclass.jsp" target="right"><span
                        class="icon-caret-right">查找班级</span></a>
            </li>
        </ul>
        <h2>
            <span class="icon-pencil-square-o"></span>学生管理
        </h2>
        <ul style="display: block">
            <li>
                <a href="" target="right"><span
                        class="icon-caret-right">学生列表</span></a>
            </li>
            <li>
                <a href="./addstudent.jsp" target="right"><span
                        class="icon-caret-right">添加学生</span></a>
            </li>
            <li>
                <a href="" target="right"><span
                        class="icon-caret-right">查找学生</span></a>
            </li>
        </ul>
    </div>
</div>
<script type="text/javascript">
    $(function() {
        $(".leftnav h2").click(function() {
            $(this).next().slideToggle(200);
            $(this).toggleClass("on");
        })
        $(".leftnav ul li a").click(function() {
            $("#a_leader_txt").text($(this).text());
            $(".leftnav ul li a").removeClass("on");
            $(this).addClass("on");
        })
    });
</script>
<ul class="bread">
    <li><a href="" target="right"
           class="icon-home"> 首页</a>
    </li>
    <li><a href="##" id="a_leader_txt">网站信息</a></li>
</ul>
<div class="admin">
    <iframe src="" name="right" width="100%"
            height="100%"></iframe>
</div>
</body>
</html>