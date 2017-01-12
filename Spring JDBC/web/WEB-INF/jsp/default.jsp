<%-- 
    Document   : default
    Created on : Mar 21, 2015, 8:10:26 AM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <c:forEach items="${employees}" var="emp">
            ${emp.getId()}) ${emp.getName()}
            
        </c:forEach>
    </body>
</html>
