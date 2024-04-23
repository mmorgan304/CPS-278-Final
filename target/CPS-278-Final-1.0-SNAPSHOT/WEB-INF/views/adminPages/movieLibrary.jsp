<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <a class="button" href="${pageContext.request.contextPath}/admin/searchMovie">Search</a>
    <a class="button" href="${pageContext.request.contextPath}/admin/main">Return to admin main</a>
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
            <tr onclick="openMovieDetailsPopup(${eachMovie.id})">
                <td>${eachMovie.title}</td>
                <td>${eachMovie.year}</td>
                <td>${eachMovie.genreList}</td>
                <td>${eachMovie.rating}</td>
                <td>${eachMovie.synopsis}</td>
                <td>${eachMovie.totalCopies}</td>
                <td>${eachMovie.availableCopies}</td>
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
