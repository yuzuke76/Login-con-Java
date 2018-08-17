
package com.ap.logindemo;


class User { 
    
    private String usuario;
    private String password;

    public User(String usuario, String password) {
        this.username = usuario;
        this.password = password;
    }

   
    public String getusuario() {
        return usuario;
    }

    
    public void setusuario(String usuario) {
        this.usuario = usuario;
    }

   
    public String getPassword() {
        return password;
    }

   
    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
