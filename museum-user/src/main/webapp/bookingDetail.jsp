<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form style="margin-left: 50px;margin-top: 50px" action="${pageContext.request.contextPath}/booking/addBooking?exhibitId=${exhibit.exhibitId}
&exhibitTitle=${exhibit.exhibitTitle}&venueName=${venue.venueName}&workerId=${venue.workId}&userId=${sessionScope.user.userId}" method="post">
    <input type="datetime-local" name="bookingTime">
    <input type="submit">
</form>
</body>
</html>
