<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form style="margin-left: 150px;margin-top: 120px" action="${pageContext.request.contextPath}/users/register">
    <div style="width: 100px;height: 60px;">
        <input style="width: 400px;margin-top: 10px" type="file" name="avatar" id="avatar">
    </div>
    <div style="width: 100px;height: 60px;">
        <label for="username">用户名：</label>
        <input style="width: 400px;margin-top: 10px" type="text" name="username" id="username">
    </div>
    <input type="hidden" name="userId" >
    <div style="width: 100px;height: 60px;">
        <label  for="password">密码：</label>
        <input style="width: 400px;margin-top: 10px" type="password" name="password" id="password" placeholder="请输入4-10位密码">
    </div>
    <div style="width: 100px;height: 60px;">
        <label for="realname">真实姓名：</label>
        <input style="width: 400px;margin-top: 10px" style="width: 300px" type="text" name="realname" id="realname">
    </div>
    <div style="width: 100px;height: 60px;">
        <label for="phone">手机号码:</label>
        <input style="width: 400px;margin-top: 10px" type="phone" name="phone" id="phone">
    </div>
    性别：
    <input type="radio" name="sex" id="man" value="男">男
    <input  type="radio" name="sex" id="woman" value="女">女 <br><br>
    <input type="submit" value="注册">
</form>

<script>
    //验证手机号
    function checkPhone() {
        var phone = $("#phone").value();
        var phoneReg = /^((13[0-9])|(17[0-1,6-8])|(15[^4,\\D])|(18[0-9]))\d{8}$/;
        if (phoneReg.test(phone)) {
            $("#phone").css("border", "1px solid green");
            return true;
        }else{
            $("#phone").css("border","1px solid red");
            return false;
        }
    }

    function checkPwd() {
        var password = $("#password").val();
        if (password.length>=4 && password.length<=10){
            return;
        } else{
            $("#password").css("border","1px solid red");
            return false;
        }

    }
</script>
</body>
</html>
