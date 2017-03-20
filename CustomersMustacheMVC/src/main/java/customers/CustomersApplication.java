package customers;

import customers.rest.CustomerController;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.mustache.MustacheMvcFeature;

@ApplicationPath("customers")
public class CustomersApplication extends ResourceConfig {

    public CustomersApplication() {
        register(MustacheMvcFeature.class);
        property(MustacheMvcFeature.TEMPLATE_BASE_PATH, "/WEB-INF/views/");
        register(CustomerController.class);

    }
}
