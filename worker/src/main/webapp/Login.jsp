<%--
  Created by IntelliJ IDEA.
  User: 18167
  Date: 2022-11-22
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="/Login.css" />
    <link rel="stylesheet" type="text/css" href="/Reset.css" />
</head>
<body>
<div class="top">
    <div class="title">
        <div class="left-top">湖工商博物馆管理系统</div>
        <div class="left-bottom">HNUC Museum Management</div>
    </div>
    <div class="all">
        <div class="right">
            <div class="login-head">登录</div>
            <form action="/worker/Check" method="post">
                <div>
                    <div class="login-username">
                        <img src="/博物馆images/用户.png"/>
                        <input name="id"/>
                    </div>
                    <div class="login-password">
                        <img src="/博物馆images/密码.png"/>
                        <input type="password" name="password"/>
                    </div>
                </div>
                <input class="login-button" value="登录" type="submit"/>
            </form>
        </div>
    </div>
</div>
<script>
    if ('<%=request.getAttribute("ok")%>'=='0'){
        alert("账号或密码输入有误！");
    }
</script>
</body>
</html>
