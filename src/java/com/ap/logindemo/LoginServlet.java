package com.ap.logindemo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    private final AuthenticationService authenticationService;

    public LoginServlet() {
    
        authenticationService = new AuthenticationService();
        authenticationService.registerUser(new User("demo", "demo"));
    
    }

    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramUsername = req.getParameter("usuario");
        String paramPassword = req.getParameter("password");
        
        if (authenticationService.authenticate(paramUsername, paramPassword)) {
            //Se l'autenticazione va a buon fine
            
            // Recupero la sessione
            HttpSession oldSession = req.getSession(false);
            if (oldSession != null) {
                oldSession.invalidate(); //invalida la sessione se esiste
            }
            
            HttpSession currentSession = req.getSession(); //crea una nuova sessione
            currentSession.setAttribute("user", paramUsername);
            currentSession.setMaxInactiveInterval(5*60); //5 minuti di inattività massima
            
            resp.sendRedirect("success.jsp"); //vai alla pagina success.jsp
            
            
        } else {
            // Se l'autenticazione fallisce
            resp.sendRedirect("login.jsp");
        }
    
    }

}
