<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
</head>
<body>

<h1>Register</h1>

<form:form method="post" action="${pageContext.request.contextPath}/register" modelAttribute="user">

    <div>
        <form:label path="username">Username:</form:label>
        <form:input path="username" required="required"/>
        <form:errors path="username" cssStyle="color:red;"/>
    </div>

    <br>

    <div>
        <form:label path="password">Password:</form:label>
        <form:password path="password" required="required"/>
        <form:errors path="password" cssStyle="color:red;"/>
    </div>

    <br>

    <button type="submit">Register</button>

</form:form>

<p>Already have an account? <a href="${pageContext.request.contextPath}/login">Login</a></p>

</body>
</html>