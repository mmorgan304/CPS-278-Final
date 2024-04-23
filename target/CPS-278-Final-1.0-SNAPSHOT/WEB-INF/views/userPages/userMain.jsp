<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ page import="java.util.Date" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css">
    <title>User Main</title>
</head>
<body>
<header class="header">
    <h1 class="header-title">${user.userName}'s Library Homepage</h1>
</header>
<div class="button-container">
<a class="button" href="${pageContext.request.contextPath}/user/searchMovie?userId=${user.userId}">Search for a movie</a>
<a class="button" href="${pageContext.request.contextPath}/user/movieLibrary?userId=${user.userId}">Browse Entire Library</a>
<a class="button" href="${pageContext.request.contextPath}/">Log out</a>
</div>
<h2 class="h2">Checkout History</h2>
<div class="whiteRed whiteRed-rounded">
    <table>
        <tr>
            <th></th>
            <th>Movie Title</th>
            <th>Checkout Date</th>
            <th>Return Date</th>
        </tr>
        <c:forEach var="checkout" items="${user.checkoutList}">
            <tr>
                <td>Checkout id: ${checkout.id}</td>
                <td>${checkout.movie.title}</td>
                <td><fmt:formatDate value="${Date.from(checkout.checkoutDate)}" pattern="MMMM d, yyyy, h:mma"/></td>
                <td>
                    <c:choose>
                        <c:when test="${checkout.returnDate == null}">
                            <form action="returnMovie" method="post">
                                <input type="hidden" name="userId" value="${user.userId}">
                                <input type="hidden" name="checkoutId" value="${checkout.id}">
                                <button class="button" type="submit">Return</button>
                            </form>
                        </c:when>
                        <c:otherwise>
                            <fmt:formatDate value="${Date.from(checkout.returnDate)}" pattern="MMMM d, yyyy, h:mma"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
