
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>

        <title>Página de Registro</title>
        <%@include file="templates/header.jsp" %>
    </head>
    <body>
        <%@include file="templates/navbar.jsp" %>
        <div class="container"><h1>Página de Registro</h1>


            <form action="${pageContext.request.contextPath}/register" method="POST">
                <div class="form-group">
                    <label for="username">Usuario</label>
                    <input type="text" id="username" name="username"/>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" name="password" />
                </div>
                <div class="form-group">
                    <label for="passwordRep">Password(again) ${requestScope.error}</label>
                    <input type="password" name="passwordRep" />
                </div>
                
                
                
                <button type="submit" class="btn btn-primary" value="Login">Registrar</button>
            </form>
        </div>
<%@include file="templates/footer.jsp" %>
