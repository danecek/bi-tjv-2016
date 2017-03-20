package customers.rest;

import customers.model.CustomerService;
import java.util.HashMap;
import java.util.Map;
import javax.enterprise.context.RequestScoped;

import javax.inject.Inject;
import javax.ws.rs.*;

import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.server.mvc.Viewable;

@Path("")
@RequestScoped
@Produces(MediaType.TEXT_HTML)
public class CustomerController {

    @Inject
    private CustomerService employeeService;

    @GET
    public Viewable index() throws Exception {
        Map<String, Object> custs = new HashMap<>();
        custs.put("customers", employeeService.getCustomers());
        return new Viewable("/index", custs);
    }

    @GET
    @Path("addCustomer")
    public Viewable addCustomer() throws Exception {
        return new Viewable("/addCustomer");
    }

    @POST
    @Path("addCustomer")
    public Viewable addCustomer(@FormParam("name") String name) throws Exception {
        if (name.length() < 3) {
            HashMap<String, Object> models = new HashMap<>();
            models.put("errorValue", name);
            models.put("errorMessage", "Too short!!!");
            return new Viewable("/addCustomer", models);
        }

        employeeService.put(name);
        return index();
//        Map<String, Object> custs = new HashMap<>();
//        custs.put("customers", employeeService.getCustomers());
//        return new Viewable("/index.html", custs);
    }
}
