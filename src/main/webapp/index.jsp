<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
    <h2>Login</h2>
    <form action="login" method="post">
        Username: <input type="text" name="username" required><br><br>
        Password: <input type="password" name="password" required><br><br>
        <input type="submit" value="Login">
    </form>

    <%-- Show error if login failed --%>
    <%
        String error = request.getParameter("error");
        if ("true".equals(error)) {
    %>
        <p style="color:red;">Invalid username or password.</p>
    <%
        }
    %>
</body>
</html>
