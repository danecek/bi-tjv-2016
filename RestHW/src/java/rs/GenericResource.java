/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("")
@RequestScoped
public class GenericResource {

    @Context
    private UriInfo context;

    @Inject
    X x;

    public GenericResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Unit getXml() {
        return new Unit();
    }


    @PUT
    public void putXml(String content) {
    }
}
