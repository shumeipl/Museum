<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>登录</title>
</head>
<body style="background-image: url('https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fpicnew13.photophoto.cn%2F20190410%2Flansegufengjianzhushufabeijing-32928107_1.jpg&refer=http%3A%2F%2Fpicnew13.photophoto.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1672082245&t=c60ad60dd292cd59f92ace6093601c8b');
background-size: cover">
<form style="margin-left: 600px;margin-top: 270px;background-color: rgba(207,207,207,0.72);width: 350px;height: 250px;"
      action="${pageContext.request.contextPath}/users/login" method="post">

    <div style="position: relative;width: 100px;height: 60px;top: 20px;margin-left: 20px">
        <label for="username">用户名：</label>
        <input style="width: 300px;margin-top: 10px" type="text" name="username" id="username"  placeholder="请输入用户名">
    </div>
    <div style="position: relative;width: 100px;height: 60px;margin-left: 20px;top: 20px;">
        <label  for="password">密码：</label>
        <input style="width: 300px;margin-top: 10px" type="password" name="password" id="password" placeholder="请输入密码">
    </div>
    ${msg}<br>
    <input style="margin-left: 50px" type="submit" value="登录">
    <a style="text-decoration: none;margin-left: 20px;" href="${pageContext.request.contextPath}/register.jsp">还没有账号？去注册&gt;</a>
</form>
</body>
</html>
