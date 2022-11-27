<%@ page import="com.example.workers.pojo.Workers" %><%--
  Created by IntelliJ IDEA.
  User: 18167
  Date: 2022-11-23
  Time: 2:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询和修改个人信息</title>
</head>
<body>
<%
    Workers worker = (Workers) session.getAttribute("worker");
    Integer workId=worker.getWorkerId();
    String avator;
   if (request.getAttribute("avator")==null){
      avator = worker.getAvatar();
   }
   else{
      avator =(String) request.getAttribute("avator");
   }
   String name = worker.getName();
    String sex=worker.getSex();
    String phone;
    if (request.getAttribute("phone")==null){
        phone =worker.getPhone();
   }
   else{
       phone = (String) request.getAttribute("phone");
   }

%>
<form action="/worker/Update?" method="post">
        <br/>工作号：<br/>
        <input name="work_id" value=<%=workId%> readonly />
        <br/>头像：<br/>
        <input name="avator" value=<%=avator%>/>
        <br/>姓名：<br/>
        <input name="name" value=<%=name%>/>
        <br/>性别：<br/>
        <input name="sex" value=<%=sex%>/>
        <br/>电话：<br/>
        <input name="phone" value="<%=phone%>"/>
        <br/>
        <input type="submit" value="提交"/>
    </form>
</body>
</html>
