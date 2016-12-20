package customers.rest;

import customers.thymeleaf.ThymeleafTemplateProcessor;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.MvcFeature;

@ApplicationPath("employee")
public class EmployeesApplication extends ResourceConfig {

    public EmployeesApplication() {
        register(MvcFeature.class);
        property(MvcFeature.TEMPLATE_BASE_PATH, "/WEB-INF/views/");
        register(EmployeeController.class);
        register(ThymeleafTemplateProcessor.class);
    }
}
