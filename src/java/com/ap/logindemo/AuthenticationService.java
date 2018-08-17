
package com.ap.logindemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AuthenticationService {
    
    private final String DB_URL = "jdbc:derby://localhost:1527/utenti";
    List<User> users;
    private final String DB="jdbc:derby://localhost:1527/users";

    public AuthenticationService() {
    users = new ArrayList<>(); 
    }
    
    private Connection getConnection() {
        try {

            return DriverManager.getConnection(DB_URL, "utenti", "utenti");
        } catch (SQLException ex) {
            Logger.getLogger(AuthenticationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    

    public boolean registerUser(User u) {
        try {
            Connection connection = getConnection();
            PreparedStatement st = connection.prepareStatement("INSERT INTO "
                    + " utenti VALUES (?,?)");
            st.setString(  1, u.getUsername());
            st.setString(2, u.getPassword());
            st.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AuthenticationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }
    
    
    public boolean authenticate(String username,String password) {
        try {
            Connection connection = getConnection();

            PreparedStatement st = connection.prepareStatement("SELECT * "
                    + " FROM utenti WHERE username=? AND password = ?");
            st.setString(  1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            
            rs.next();
            String user = rs.getString("username");
            

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AuthenticationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean usernameExists(String username) {
        try {
            Connection connection = getConnection();
            PreparedStatement st = connection.prepareStatement("SELECT * FROM users"
                    + " WHERE username=?");
            st.setString(1, username);
            
            ResultSet rs = st.executeQuery();
            rs.next();
            rs.getString("username");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AuthenticationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }
}
