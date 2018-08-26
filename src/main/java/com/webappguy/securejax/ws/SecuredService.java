/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webappguy.securejax.ws;

import com.webappguy.securejax.auth.RestSecured;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author Vincent Lee
 */
@Path("/secured")
@RestSecured
public class SecuredService {
    
    @GET
    public Response get() {
        
        try {
            Date start = new Date();
            // If operation takes a long time...
            TimeUnit.SECONDS.sleep(10);
            Date end = new Date();
            long timeTaken = end.getTime() - start.getTime();
            return Response.ok("This operation took " + timeTaken + " milliseconds").build();
            
        } catch (InterruptedException ex) {
            return Response.ok("Interrupted but still authenticated.").build();
        }
    }
}
