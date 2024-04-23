<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css">
    <title>Title Search</title>
</head>
<body>
<div class="form-container">
    <h2 class="form-title">Title Search</h2>
    <form:form action="processSearchRequest" modelAttribute="searchTerms" method="post">
        <table>
            <tr>
                <td class="form-label">Title:</td>
                <td>
                    <form:input class="form-input" path="title"/>
                </td>
            </tr>
            <tr>
                <td class="form-label">Description:</td>
                <td>
                    <form:input class="form-input" path="description"/>
                </td>
            </tr>
            <tr>
                <td class="form-label">Genre:</td>
                <td>
                    <form:select class="form-select" path="genre">
                        <form:option value="" label="-- Select Genre --"/>
                        <form:options items="${genreList}"/>
                    </form:select>
                </td>
            </tr>
        </table>
        <input type="hidden" name="userId" value="${user.userId}">
        <button class="form-submit" type="submit">Search Movie Database</button>
    </form:form>
</div>
</body>
</html>
