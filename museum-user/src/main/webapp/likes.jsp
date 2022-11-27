<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <table border="1" width="90%">
        <tr>
            <td>收参编号</td>
            <td>收藏品编号</td>
            <td>收藏时间</td>
        </tr>
        <c:forEach items="${likeList}" var="allLikes">
            <tr>
                <td>${allLikes.likeId}</td>
                <td>${allLikes.collectionId}</td>
                <td>${allLikes.collectionTime}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
