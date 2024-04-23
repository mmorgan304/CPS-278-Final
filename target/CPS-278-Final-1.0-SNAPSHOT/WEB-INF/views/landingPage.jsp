<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css">
    <title>Movie Library</title>
</head>
<body>
<div class="login-container">
    <h1 class="login-title">Movie Library</h1>
    <form:form action="${pageContext.request.contextPath}/user/main" modelAttribute="user" method="get">
        <div class="form-container">
            <label class="form-label" for="userId">Select User:</label>
            <br>
            <form:select class="form-select" path="userId" id="userId" items="${userList}" itemLabel="userName"
                         itemValue="userId"/>
            <button type="submit" class="login-button">Login</button>
        </div>
    </form:form>
    <p class="admin-login-link">Or <a href="${pageContext.request.contextPath}/admin/main">log in as administrator</a>
    </p>
</div>
</body>
</html>
