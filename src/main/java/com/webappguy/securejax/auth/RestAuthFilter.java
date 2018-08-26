/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webappguy.securejax.auth;

import java.io.IOException;
import javax.inject.Inject;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Vincent Lee
 */
@Provider
@RestSecured
public class RestAuthFilter implements ContainerRequestFilter {

    @Inject User user;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        /**
         * Unlike normal web filters, you throw exception if you want to stop a
         * request.
         */
        if (!user.isAuthenticated()) {
            throw new NotAuthorizedException("User is not authenticated!");
        };
        
    }
}
