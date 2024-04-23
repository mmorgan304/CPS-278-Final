<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css">
    <title>Add Movie</title>
</head>
<body>
<div class="form-container">
    <h2 class="form-title">Add/Modify Movie</h2>
    <form:form action="processMovie" modelAttribute="newMovie" method="post">
        <table>
            <tr>
                <td class="form-label">Title:</td>
                <td>
                    <form:input class="form-input" path="title"/>
                    <form:errors path="title"/>
                </td>
            </tr>
            <tr>
                <td class="form-label">Synopsis:</td>
                <td>
                    <form:textarea class="form-textarea" path="synopsis"/>
                    <form:errors path="synopsis"/>
                </td>
            </tr>
            <tr>
                <td class="form-label">Length (mins):</td>
                <td>
                    <form:input class="form-input" path="length"/>
                    <form:errors path="length"/>
                </td>
            </tr>
            <tr>
                <td class="form-label">Release Year:</td>
                <td>
                    <form:input class="form-input" path="year"/>
                    <form:errors path="year"/>
                </td>
            </tr>
            <tr>
                <td class="form-label">Rating:</td>
                <td>
                    <form:select class="form-select" path="rating">
                        <form:options items="${ratingsList}"/>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td class="form-label">Genre:</td>
                <td class="form-checkbox-group">
                    <form:checkboxes path="genreList" items="${genreList}"/>
                </td>
            </tr>
            <tr>
                <td class="form-label">Copies to Add:</td>
                <td>
                    <form:input class="form-input" path="totalCopies"/>
                    <form:errors path="totalCopies"/>
                </td>
            </tr>
        </table>
        <input class="button" type="submit" value="Add Movie">
    </form:form>
</div>
<div class="button-container">
    <a class="button" href="${pageContext.request.contextPath}/admin/main">Return to admin main</a>
</div>
</body>
</html>
