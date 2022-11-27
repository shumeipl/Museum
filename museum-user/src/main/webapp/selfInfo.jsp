<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h3>个人信息中心</h3>
    <img style="width: 100px;height: 100px;border-radius: 50%" src="${self.avatar}" alt="">
    <p>昵称：${self.username}</p>
    <p>真实姓名：${self.realname}</p>
    <p>手机号：${self.phone}</p>
    <p>性别：${self.sex}</p>
    <a href="${pageContext.request.contextPath}/users/updatePage?userId=${self.userId}">修改</a>
    <a href="${pageContext.request.contextPath}/index">返回首页</a>
</center>
</body>
</html>
