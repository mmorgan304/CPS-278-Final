<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css">
    <title>Movie Library</title>
</head>
<body>
<header class="header">
    <h1 class="header-title">Movie Library</h1>
</header>
<div class="button-container">
    <a class="button" href="${pageContext.request.contextPath}/user/searchMovie?userId=${user.userId}">Search</a>
    <a class="button" href="${pageContext.request.contextPath}/user/main?userId=${user.userId}">Return to user main</a>
</div>
<div class="whiteRed whiteRed-rounded">
<table>
    <tr>
        <th>Title</th>
        <th>Year</th>
        <th>Genre</th>
        <th>Rating</th>
        <th>Synopsis</th>
        <th>Total Copies</th>
        <th>Available Copies</th>
    </tr>
    <c:forEach var="eachMovie" items="${movieList}">
        <tr>
            <td onclick="openMovieDetailsPopup(${eachMovie.id})">${eachMovie.title}</td>
            <td onclick="openMovieDetailsPopup(${eachMovie.id})">${eachMovie.year}</td>
            <td onclick="openMovieDetailsPopup(${eachMovie.id})">${eachMovie.genreList}</td>
            <td onclick="openMovieDetailsPopup(${eachMovie.id})">${eachMovie.rating}</td>
            <td onclick="openMovieDetailsPopup(${eachMovie.id})">${eachMovie.synopsis}</td>
            <td onclick="openMovieDetailsPopup(${eachMovie.id})">${eachMovie.totalCopies}</td>
            <td onclick="openMovieDetailsPopup(${eachMovie.id})">${eachMovie.availableCopies}</td>
            <td>
                <c:choose>
                    <c:when test="${eachMovie.availableCopies == 0}">
                        Unavailable
                    </c:when>
                    <c:otherwise>
                        <form action="checkMovieOut" method="post">
                            <input type="hidden" name="userId" value="${user.userId}">
                            <input type="hidden" name="movieId" value="${eachMovie.id}">
                            <button  class="button" type="submit">Checkout</button>
                        </form>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
</table>
</div>

<script>
    function openMovieDetailsPopup(movieId) {
        window.open('${pageContext.request.contextPath}/movieDetailsPage?movieId=' + movieId, 'MovieDetails', 'width=800,height=400,scrollbars=yes');
    }
</script>

</body>
</html>
