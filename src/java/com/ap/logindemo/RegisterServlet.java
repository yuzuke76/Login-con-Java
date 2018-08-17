/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ap.logindemo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author prof.andreapollini
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    private AuthenticationService authService;

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.

        
        authService = new AuthenticationService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String passwordRep = req.getParameter("passwordRep");
        
        if(!password.equals(passwordRep)) {
            req.setAttribute("error", "Passwords doesn't match");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
            
            return;
        }
        
        User u = new User(username, password);
        
        if(!authService.registerUser(u)) {
            resp.sendRedirect("register.jsp");
            return;
        }
        resp.sendRedirect("index.jsp");
    
    }



}
