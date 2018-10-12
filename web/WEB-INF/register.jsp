<%-- 
    Document   : register
    Created on : Oct 9, 2018, 12:17:24 PM
    Author     : 738409
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <br>
        <form action="shoppinglist" method="post">
            Username: <input type="text" name="username" value="${username}">
            <button type="submit">Register Name</button>
            <input type="hidden" name="action" value="register">

            <br>
            ${error}
        </form>

    </body>
</html>
