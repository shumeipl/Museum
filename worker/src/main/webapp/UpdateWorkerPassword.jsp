<%--
  Created by IntelliJ IDEA.
  User: 18167
  Date: 2022-11-23
  Time: 2:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
</head>
<body>
<form action="/worker/UpdatePW" method="post">
    <br/>原密码：<br/>
    <input type="password" name="oldPassword"/>
    <br/>新密码：<br/>
    <input type="password" name="newPassword"/>
    <br/>再次输入新密码：<br/>
    <input type="password" name="newPasswordAgain"/>
    <br/>
    <input type="submit" value="修改"/>
</form>
</body>
</html>
