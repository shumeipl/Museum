<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <table border="1" width="90%">
        <tr>
            <td>预约编号</td>
            <td>展览标题</td>
            <td>预约时间</td>
            <td>馆名</td>
            <td>审核状态</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${bookingList}" var="allBooking">
            <tr>
                <td>${allBooking.bookingId}</td>
                <td>${allBooking.venueName}</td>
                <td>${allBooking.venueType}</td>
                <td>${allBooking.bookingTime}</td>
                <td>${allBooking.workerId}</td>
                <td><a href="${pageContext.request.contextPath}/booking/deleteOne?bookingId=${allBooking.bookingId}&userId=${allBooking.userId}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
    <a href="${pageContext.request.contextPath}/exhibits/getAllExhibits">预约</a>
</div>
</body>
</html>
