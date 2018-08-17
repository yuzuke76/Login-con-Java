<%-- 
    Document   : index
    Created on : 24-mar-2018, 18.33.57
    Author     : prof.andreapollini
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
    <head>
        
        <title>Hello, world!</title>
        <%@include file="templates/header.jsp" %>
    </head>
    <body>
        <%@include file="templates/navbar.jsp" %>
        <a href="${pageContext.request.contextPath}/register.jsp">Register</a>
            </body>
</html>
