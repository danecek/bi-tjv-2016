/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs;

import data.User;
import data.Users;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("")
@RequestScoped
@Produces(MediaType.APPLICATION_XML)

public class UsersResource {

    @Inject
    Users elements;

    @GET
    public List<User> allUsers() {
        return elements.all();
    }

    @GET
    @Path("{id}")
    public User userById(@PathParam("id") Integer id) {
        return elements.find(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public void addUser(User user) {
        elements.add(user);
    }
}
