<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>

<body>

<h1>Login</h1>

<form action="${pageContext.request.contextPath}/login" method="post">

    <input
            type="hidden"
            name="${_csrf.parameterName}"
            value="${_csrf.token}"
    />

    <div>
        <label>Username:</label>
        <input type="text" name="username" required>
    </div>

    <br>

    <div>
        <label>Password:</label>
        <input type="password" name="password" required>
    </div>

    <br>

    <button type="submit">Login</button>

</form>

</body>
</html>