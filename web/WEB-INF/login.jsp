<%-- 
    Document   : login
    Created on : Feb 22, 2021, 11:18:15 AM
    Author     : 735815
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    
    <body>
        <h1>Login Page</h1>
        <br>
        <br>
        <form method="POST">
            <label for="title"> Username: 
        </label>           
            <input type="text" name="username" value="${username}">
            <br>
            
                  <label for="title"> Password: 
        </label>  
            <input type="text" name="password" value="${password}">
            <br>
            
            <input type="submit" name="login" value="login">
            <br>
            ${message}
            
    </form>
    </body>
</html>
