package customers.rest;

import customers.model.CustomerService;
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
public class CustomerController {

    @Inject
    private CustomerService customerService;

    @GET
    @Path("index")
    public Viewable index() throws Exception {
        return new Viewable("/index.html",
                Collections.singletonMap("customers",
                        customerService.getCustomers()));
    }

    @GET
    @Path("addCustomer")
    public Viewable addCustomer() throws Exception {
        return new Viewable("/addCustomer.html");
    }

    @POST
    @Path("addCustomer")
    public Viewable addCustomer(@FormParam("name") String name) throws Exception {
        if (name.length() < 3) {
            HashMap<String, Object> models = new HashMap<>();
            models.put("errorValue", name);
            models.put("errorMessage", "Too short!!!");
            return new Viewable("/addCustomer.html", models);
        }
        customerService.put(name);
        return index();
    }

}
