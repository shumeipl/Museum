<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/exhibits.css">
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
    <div class="img">
        <img src="https://www.nhmuseum.org/upfile/adPic/image/20181025/20181025143317_30420.jpg" alt="">
    </div>
    <div class="box-type">
        <ul class="type">
            <li><a href="${pageContext.request.contextPath}/exhibits/getExhibitsByStatePage?state=3">临时展览</a></li>
            <li><a href="${pageContext.request.contextPath}/exhibits/getExhibitsByStatePage?state=2">展览预告</a></li>
            <li><a href="${pageContext.request.contextPath}/exhibits/getExhibitsByStatePage?state=1">往期回顾</a></li>
        </ul>
        <ul class="exhibits">
            <c:forEach items="${exhibits}" var="exhibit">
                <li>
                    <a href="${pageContext.request.contextPath}/exhibits/getExhibitById?exhibitId=${exhibit.exhibitId}">${exhibit.exhibitTitle}</a>
                </li>
            </c:forEach>
        </ul>
        <img src="https://www.nhmuseum.org/upfile/proPic/image/20221020/20221020094347_61724.jpg" alt="">
    </div>
    <div class="page">
        <ul>
            <li class="a"><a href="${pageContext.request.contextPath}/exhibits/getExhibitsByStatePage?currentPage=1&state=${state}">首页</a></li>
            <c:if test="${currentPage-1>=1}">
                <li class="b"><a href="${pageContext.request.contextPath}/exhibits/getExhibitsByStatePage?currentPage=${currentPage-1}&state=${state}">&lt;</a></li>
            </c:if>
            <li class="c">${currentPage}</li>
            <c:if test="${currentPage+1 <= totalPages}">
                <li class="d"><a href="${pageContext.request.contextPath}/exhibits/getExhibitsByStatePage?currentPage=${currentPage+1}&state=${state}">&gt;</a></li>
            </c:if>
            <li><a href="${pageContext.request.contextPath}/announcements/getAnnouncementsByPage?currentPage=${totalPages}&state=${state}">尾页</a></li>
        </ul>
    </div>
</div>
</body>
</html>
