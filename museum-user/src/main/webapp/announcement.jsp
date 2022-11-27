<%@ page import="org.springframework.ui.ModelMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>公告</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/announcement.css">
</head>
<body>
<div class="box" style="width: 100%;">
    <div class="name" style="width: 100%">湖南工商大学博物馆</div>
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
    <div class="img">
        <img src="https://www.nhmuseum.org/upfile/adPic/image/20181025/20181025145341_24919.jpg" alt="">
    </div>

    <div class="announcement">
        <p>公告</p>
        <ul class="announcement-left">
            <c:forEach items="${announcementsPageList}" var="announcementsByPage">
                <li><a class="a-left" href="${pageContext.request.contextPath}/announcements/getAnnouncementById?AId=${announcementsByPage.AId}">${announcementsByPage.title}</a><a class="a-right" href="">${announcementsByPage.createTime}</a></li>
            </c:forEach>
        </ul>
        <div class="announcement-right">
            <div class="poem">
            <h3>无 题</h3>
            <p>[唐]李商隐</p>
            <p>相 见 时 难 别 亦 难，</p>
            <p>东 风 无 力 百 花 残。</p>
            <p>春 蚕 到 死 丝 方 尽，</p>
            <p>蜡 炬 成 灰 泪 始 干。</p>
            </div>
        </div>
        <div class="page">
            <ul>
                <li class="a"><a href="${pageContext.request.contextPath}/announcements/getAnnouncementsByPage?currentPage=1">首页</a></li>
                <c:if test="${currentPage-1>=1}">
                    <li class="b"><a href="${pageContext.request.contextPath}/announcements/getAnnouncementsByPage?currentPage=${currentPage-1}">&lt;</a></li>
                </c:if>
                <li class="c"><a href="${pageContext.request.contextPath}/announcements/getAnnouncementsByPage">${currentPage}</a></li>
                <c:if test="${currentPage+1 <= pages}">
                    <li class="d"><a href="${pageContext.request.contextPath}/announcements/getAnnouncementsByPage?currentPage=${currentPage+1}">&gt;</a></li>
                </c:if>
                <li><a href="${pageContext.request.contextPath}/announcements/getAnnouncementsByPage?currentPage=${pages}">尾页</a></li>
            </ul>
        </div>
    </div>
</div>

<script>
    function changePage(num){

    }
</script>
</body>
</html>
