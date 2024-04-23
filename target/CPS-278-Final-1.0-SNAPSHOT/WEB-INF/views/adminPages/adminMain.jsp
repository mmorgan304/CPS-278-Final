<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css">
    <title>Administrator Main</title>
</head>
<body>
<div class="admin-container">
    <h1 class="admin-title">Admin Main</h1>
    <ul class="admin-menu">
        <li><a href="${pageContext.request.contextPath}/admin/addMovie">Add Movie</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/searchMovie">Search for a Movie</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/movieLibrary">View All Movies</a></li>
        <li><a href="${pageContext.request.contextPath}/api/movies">API: Get All Movies</a></li>
        <li><a href="${pageContext.request.contextPath}/api/users">API: Get All Users</a></li>
        <li><a href="${pageContext.request.contextPath}/">Log Out</a></li>
    </ul>
</div>
</body>
</html>
