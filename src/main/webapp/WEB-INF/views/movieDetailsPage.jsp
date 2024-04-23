<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css">
    <title>Title</title>
</head>
<body>
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
        <tr>
            <td>${movie.title}</td>
            <td>${movie.year}</td>
            <td>${movie.genreList}</td>
            <td>${movie.rating}</td>
            <td>${movie.synopsis}</td>
            <td>${movie.totalCopies}</td>
            <td>${movie.availableCopies}</td>
        </tr>
    </table>
</div>
</body>
</html>
