<%-- 
    Document   : AdminLogin
    Created on : Apr 15, 2016, 12:32:53 PM
    Author     : choud
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Login</title>
    </head>
    <body>
        <h1>Admin Login</h1>
        <a href="index.jsp">Home</a>|
        <a href="StudentLogin.jsp">Student</a><br/>
        ${message}
        <form method="post">
            User Name: <input type="text" name="userName_txt"><br/>
            Password: <input type="text" name="password_txt"><br/>
            <input type="Submit" name="admin_submit" value="Submit" onclick="form.action='LoginServlet';"><br/>
        </form>


    </body>
</html>
