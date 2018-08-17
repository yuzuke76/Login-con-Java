<%-- 
    Document   : login
    Created on : 24-mar-2018, 18.05.45
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
        <div class="container"><h1>Login Page</h1>


            <form action="${pageContext.request.contextPath}/login" method="POST">
                <input type="text" name="username"/>
                <input type="password" name="password" />
                <input type="submit" value="Login"/>
            </form>
        </div>
    </body>
</html>


