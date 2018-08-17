
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">Login Demo</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="nav-item nav-link active" href="${pageContext.request.contextPath}/">Home</a>
                <a class="nav-item nav-link" href="${pageContext.request.contextPath}/login.jsp">Login</a>
                <a class="nav-item nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
                
                <a class="nav-item nav-link" href="#">Eventos</a>
                <a class="nav-item nav-link disabled" href="#">Hola,${user}</a>
            </div>
        </div>
    </nav>

</div>
