<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/announcementDetail.css">
</head>

<body>
<div class="box">
    <div class="name" style="width: 100%">湖南工商大学博物馆</div>
    <div class="nav" >
        <ul class="nav-ul" style="list-style: none">
            <li><a style="height:50px;line-height: 50px;padding: 10px 50px" href="${pageContext.request.contextPath}/index">首页</a></li>
            <li><a style="height:50px;line-height: 50px;padding: 10px 50px" href="${pageContext.request.contextPath}/announcements/getAnnouncementsByPage">公告</a></li>
            <li><a style="height:50px;line-height: 50px;padding: 10px 50px" href="${pageContext.request.contextPath}/collections/getByTypePage">鉴赏</a></li>
            <li><a style="height:50px;line-height: 50px;padding: 10px 50px" href="${pageContext.request.contextPath}/exhibits/getExhibitsByStatePage">展览</a></li>
            <li><a style="height:50px;line-height: 50px;padding: 10px 50px" href='${pageContext.request.contextPath}/venues/getVenueByName?venueName="${sessionScope.venueList[0].venueName}"'>服务</a></li>
            <li class="my">
                <c:if test="${sessionScope.user == null}">
                    <a style="height:50px;line-height: 50px;padding: 10px 50px" href="${pageContext.request.contextPath}/login.jsp">登录/注册</a>
                </c:if>
                <c:if test="${sessionScope.user.username != null}">
                    <img class="avatar" style="width: 70px;height: 70px;border-radius: 50%;position: relative;top: -20px;left: 65px;display: block;" src="${sessionScope.user.avatar}" alt="">
                    <ul class="mychild" >
                        <li><a href="${pageContext.request.contextPath}/users/selfInfo?userId=${sessionScope.user.userId}">个人信息</a></li>
                        <li><a href="${pageContext.request.contextPath}/booking/getBookingByIdPage?userId=${sessionScope.user.userId}">预约记录</a></li>
                        <li><a href="${pageContext.request.contextPath}/likes/allLikes?userId=${sessionScope.user.userId}">我的收藏</a></li>
                        <li><a href="">退出登录</a></li>
                    </ul>
                </c:if>
            </li>
        </ul>
    </div>

<div class="bottom">
    <h2>公告</h2>
    <h3 class="title">${announcement.title}</h3>
    <p>${announcement.content}</p>
    <img src="${announcement.photo}" alt="">
</div>
</div>
</body>
</html>
