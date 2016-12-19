package com.example.rest.controller;

import com.example.model.EmployeeService;
import java.util.Collections;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;

import java.util.HashMap;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.server.mvc.Viewable;

@Path("")
@RequestScoped
@Produces(MediaType.TEXT_HTML)
public class EmployeeController {

    @Inject
    private EmployeeService employeeService;

    @GET
    @Path("index")
    public Viewable index() throws Exception {
        return new Viewable("/employee/index.html",
                Collections.singletonMap("employees",
                        employeeService.getEmployees()));
    }

    @GET
    @Path("addCustomer")
    public Viewable addCustomer() throws Exception {
        return new Viewable("/employee/addCustomer.html");
    }

    @POST
    @Path("addCustomer")
    public Viewable addCustomer(@FormParam("name") String name) throws Exception {
        if (name.length() < 3) {
            HashMap<String, Object> models = new HashMap<>();
            models.put("errorValue", name);
            models.put("errorMessage", "Too short!!!");
            return new Viewable("/employee/addCustomer.html", models);
        }
        employeeService.put(name);
        return index();
    }

}
