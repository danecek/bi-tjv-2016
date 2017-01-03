package customers.thymeleaf;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;
import org.glassfish.jersey.server.mvc.Viewable;
import org.glassfish.jersey.server.mvc.spi.AbstractTemplateProcessor;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@Provider
public class ThymeleafTemplateProcessor extends AbstractTemplateProcessor<String> {

    @Inject
    private HttpServletRequest httpServletRequest;
    @Inject
    private HttpServletResponse httpServletResponse;

    private TemplateEngine templateEngine;

    @Inject
    public ThymeleafTemplateProcessor(Configuration config, ServletContext servletContext) {
        super(config, servletContext, "html", "html");
        ServletContextTemplateResolver templateResolver
                = new ServletContextTemplateResolver(servletContext);
        templateResolver.setPrefix("/WEB-INF/views/");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
    }

    @Override
    protected String resolve(String templatePath, Reader reader) throws Exception {
        return templatePath;
    }

    @Override
    public void writeTo(String templateReference, Viewable viewable, MediaType mediaType,
            MultivaluedMap<String, Object> httpHeaders, OutputStream out) throws IOException {
        WebContext webContext = new WebContext(
                httpServletRequest, httpServletResponse,
                getServletContext()
        );
        webContext.setVariables((Map<String, Object>) viewable.getModel());
        try (Writer writer = new OutputStreamWriter(out, StandardCharsets.UTF_8)) {
            templateEngine.process(viewable.getTemplateName(), webContext, writer);
        }
    }

}
