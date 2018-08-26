/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webappguy.securejax.form;

import com.webappguy.securejax.auth.User;
import java.io.IOException;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Vincent Lee
 */
@RequestScoped
@Named("FormLogin")
public class FormLogin {
    
    @Inject User user;
    
    String password;
    String message;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
    public void login() {
        try {
            user.setAuthenticated("password".equals(password));
            
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            ec.redirect(ec.getRequestContextPath() + "/secure/index.xhtml");
        } catch (IOException ex) {
            user.setAuthenticated(false);
            throw new RuntimeException(ex);
        }
    }
    
    public void logout() {
        try {
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            ec.invalidateSession();
            ec.redirect(ec.getRequestContextPath() + "/secure/index.xhtml");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
