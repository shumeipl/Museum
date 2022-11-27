<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body style="background-color: #fff1e5;
background-image: url('https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fpic.616pic.com%2Fbg_w1180%2F00%2F05%2F20%2F5ZjXYIMLWh.jpg&refer=http%3A%2F%2Fpic.616pic.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1672082208&t=55ab63d0f094d04ee7582dc4c15ac818');
background-size: cover">
<form style="margin-left: 150px;margin-top: 120px" action="${pageContext.request.contextPath}/users/update">
    <div style="width: 100px;height: 60px;">
        <input style="width: 400px;margin-top: 10px" type="image" name="avatar" id="avatar" value="${info.avatar}">
    </div>
    <div style="width: 100px;height: 60px;">
    <label for="username">用户名：</label>
    <input style="width: 400px;margin-top: 10px" type="text" name="username" id="username" value="${info.username}">
    </div>
            <input type="hidden" name="userId" value="${info.userId}">
    <div style="width: 100px;height: 60px;">
    <label  for="password">密码：</label>
    <input style="width: 400px;margin-top: 10px" type="password" name="password" id="password" value="${info.password}">
    </div>
    <div style="width: 100px;height: 60px;">
    <label for="realname">真实姓名：</label>
    <input style="width: 400px;margin-top: 10px" style="width: 300px" type="text" name="realname" id="realname" value="${info.realname}">
    </div>
    <div style="width: 100px;height: 60px;">
    <label for="phone">手机号码:</label>
    <input style="width: 400px;margin-top: 10px" type="phone" name="phone" id="phone" value="${info.phone}">
    </div>
    性别：
    <input type="radio" name="sex" id="man" value="男"
    <c:if test="${info.sex=='男'}">checked="checked"</c:if>>男
    <input  type="radio" name="sex" id="woman" value="女"
           <c:if test="${info.sex == '女'} " >checked="checked"</c:if>>女 <br><br>
    <input type="submit" value="保存">
    <a style="display: block;position: relative;text-decoration: none;color: black;top: 20px;" href="${pageContext.request.contextPath}/index">首页&gt;</a>
</form>

</body>
</html>
