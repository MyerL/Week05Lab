<%-- 
    Document   : shoppinglist
    Created on : Oct 9, 2018, 12:17:45 PM
    Author     : 738409
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    ArrayList<String> list = (ArrayList<String>) session.getAttribute("list");

    session.setAttribute("items", list);


%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>ShoppingList</h1>
        <br>
        Hello, ${registereduser} 
        <%-- 
               LOGOUT
        --%>
<!--        <form action="shoppinglist" method="post">
            <button type="submit">Logout</button>
            <input type="hidden" name="action" value="logout">
        </form>-->
       
            <a href="<c:url value='shoppinglist?action=logout'/>">Logout</a>
        <br>
        <%-- 
               ADD
        --%>
        <h1>List</h1>
        <form action="shoppinglist" method="post">
            AddItem: <input type="text" name="iteminput" value="${iteminput}">
            <button type="submit">Add</button>
            <input type="hidden" name="action" value="add">
            <br>
            ${error}
        </form>
        <%-- 
                DISPLAY && DELETE
        --%>

           <form action="shoppinglist" method="post">
            <c:forEach items="${items}" var="item">
                <input type="radio" name="added" value="${item}">${item}<br>
            </c:forEach>
            <br>
            <button type="submit">Delete</button>
            <input type="hidden" name="action" value="delete">
            <br>
            ${errordelete}
        </form>
    </body>
</html>
