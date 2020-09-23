<%-- 
    Document   : helloWorldForm
    Created on : 21-Sep-2020, 12:20:20 PM
    Author     : cprg352
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Age Calculator</title>
    </head>
    <body>
        <h1>Age Calculator</h1>
        <form method="post" action="age">
            Enter your age: <input type="text" name="age"><br>
            <input type="submit" value="Age next birthday">
            <p>${result}</p>
            <a href="arithmetic">Arithmetic Calculator</a>
        </form>
    </body>
</html>
