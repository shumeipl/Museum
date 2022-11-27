<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
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
                            <li><a href="${pageContext.request.contextPath}/loginOut.jsp">退出登录</a></li>
                        </ul>
                </c:if>
        </li>
    </ul>
    </div>

    <div class="banner">
        <ul class="imgbox">
                <li class="active"><img class="img" src="${sessionScope.photosList[0].photo}" alt=""></li>
        </ul>
        <!--焦点-->
        <ol>
            <c:forEach items="${sessionScope.photoList}" var="photos">
                <li data-i="${photos.photoId}" data-name="point"></li>
            </c:forEach>
        </ol>
        <!--左右切换按钮-->
        <div class="left">&lt;</div>
        <div class="right">&gt;</div>
    </div>

    <div class="announcement">
        <c:forEach items="${sessionScope.announcements}" var="announcement">
            <a href="${pageContext.request.contextPath}/announcements/getAnnouncementById?AId=${announcement.AId}">${announcement.title}</a>
        </c:forEach>
        <a href="${pageContext.request.contextPath}/announcements/getAnnouncementsByPage">更多&gt;&gt;</a>
    </div>
    <div class="exhibit">
        <c:forEach items="${sessionScope.exhibits}" var="exhibit">
            <a href="${pageContext.request.contextPath}/exhibits/getExhibitById?exhibitId=${exhibit.exhibitId}">${exhibit.exhibitTitle}</a>
        </c:forEach>
        <a href="${pageContext.request.contextPath}/exhibits/getExhibitsByStatePage">更多&gt;&gt;</a>
    </div>
    <div class="collection">
        <c:forEach items="${sessionScope.collections}" var="collection">
            <div class="img">
            <a href="${pageContext.request.contextPath}/collections/getCollectionById?collectionId=${collection.collectionId}">
                <img src="${collection.photo}" alt="">
                <div>
                    <a href="${pageContext.request.contextPath}/collections/getCollectionById?collectionId=${collection.collectionId}">${collection.collectionName}</a>
                </div>
            </a>
            </div>
        </c:forEach>
        <a class="more" href="${pageContext.request.contextPath}/collections/getByTypePage">更多&gt;&gt;</a>
    </div>

    <script>
        var img = document.querySelector('.img');
        console.log(img);
        var points = document.querySelectorAll('ol>li');
        var banner = document.querySelector('.banner');
        let i = 0;
        function changeImg(type) {
            if (type === true){
                i++;
                if(i % 4 === 1){
                    img.src = "${sessionScope.photosList[1].photo}";
                }
               else if(i % 4 === 2) {
                   img.src = "${sessionScope.photosList[2].photo}"
               }
               else if(i % 4 === 3){
                   img.src = "${sessionScope.photosList[3].photo}"
               }
              else if(i % 4 === 0){
                  img.src = "${sessionScope.photosList[0].photo}"
                }
            } else if (type === false){
                i--;
                if(i < 0){
                    img.src = "${sessionScope.photosList[3].photo}"
                }
                if(i % 4 === 1){
                    img.src = "${sessionScope.photosList[1].photo}";
                }
                else if(i % 4 === 2) {
                    img.src = "${sessionScope.photosList[2].photo}"
                }
                else if(i % 4 === 3){
                    img.src = "${sessionScope.photosList[3].photo}"
                }
                else if(i % 4 === 0){
                    img.src = "${sessionScope.photosList[0].photo}"
                }
            }
        }

        banner.onclick = function (e) {
            console.log('点击事件');
            if(e.target.className === 'left'){
                console.log('点击的是左按钮');
                changeImg(false);
            }
            if(e.target.className === 'right'){
                console.log('点击的是右按钮');
                changeImg(true)
            }
        };

        setInterval(function () {
            changeImg(true)
        },3000)
    </script>
</div>
</body>
</html>
