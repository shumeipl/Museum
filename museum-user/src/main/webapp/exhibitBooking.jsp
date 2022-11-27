<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/exhibitService.css">
</head>
<body>
<div class="box">
    <div class="name">湖南工商大学博物馆</div>
    <div class="nav">
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

    <div class="booking" style="background-image: url('https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fpic.616pic.com%2Fbg_w1180%2F00%2F23%2F97%2F8rT87WpUoq.jpg&refer=http%3A%2F%2Fpic.616pic.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1672082208&t=548024b57974473ed7a2ce59734a70e9');background-size: cover">
    <ul>
        <c:forEach items="${exhibitList}" var="exhibit">
            <li>
                <div class="left">
                <a href="${pageContext.request.contextPath}/exhibits/getExhibitById?exhibitId=${exhibit.exhibitId}">${exhibit.exhibitTitle}</a>
                </div>
                <div class="right">
                <a  href="${pageContext.request.contextPath}/exhibits/getExhibitById2?exhibitId=${exhibit.exhibitId}&venueId=${exhibit.venueId}&userId=${sessionScope.user.userId}">预约</a>
                </div>
            </li>
        </c:forEach>
    </ul>
    </div>
</div>
</body>
</html>
