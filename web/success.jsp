<%-- 
    Document   : success
    Created on : 24-mar-2018, 18.22.51
    Author     : prof.andreapollini
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
 String user = null;
 if(session.getAttribute("user") == null)
    response.sendRedirect("login.jsp");
 else
    user = (String)session.getAttribute("user");
%>
<!doctype html>
<html lang="en">
    <head>

        <title>Hello, world!</title>
        <%@include file="templates/header.jsp" %>
    </head>
    <body>
        <%@include file="templates/navbar.jsp" %>
        <div class="container"><h1>Reserved area for: ${user}</h1>


        </div>
    </body>
</html>
