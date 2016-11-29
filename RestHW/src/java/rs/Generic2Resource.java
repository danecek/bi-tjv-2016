/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author danecek
 */
@Path("generic2")
public class Generic2Resource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Generic2Resource
     */
    public Generic2Resource() {
    }

    /**
     * Retrieves representation of an instance of rs.Generic2Resource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getText(@QueryParam("name") String name) {
        return "Hello " + name;
    }

    /**
     * PUT method for updating or creating an instance of Generic2Resource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public void putText(String content) {
    }
}
