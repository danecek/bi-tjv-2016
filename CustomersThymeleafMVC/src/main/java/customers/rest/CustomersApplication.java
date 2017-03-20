package customers.rest;

import customers.thymeleaf.ThymeleafTemplateProcessor;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.MvcFeature;

@ApplicationPath("customers")
public class CustomersApplication extends ResourceConfig {

    public CustomersApplication() {
        register(MvcFeature.class);
        property(MvcFeature.TEMPLATE_BASE_PATH, "/WEB-INF/views/");
        register(CustomerController.class);
        register(ThymeleafTemplateProcessor.class);
    }
}
