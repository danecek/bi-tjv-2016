package com.example.rest;

import com.example.rest.controller.EmployeeController;
import com.example.rest.thymeleaf.ThymeleafTemplateProcessor;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.MvcFeature;

@ApplicationPath("employee")
public class MyApplication extends ResourceConfig {

    public MyApplication() {
        register(MvcFeature.class);
        property(MvcFeature.TEMPLATE_BASE_PATH, "/WEB-INF/views/");
        register(EmployeeController.class);
        register(ThymeleafTemplateProcessor.class);

    }
}
