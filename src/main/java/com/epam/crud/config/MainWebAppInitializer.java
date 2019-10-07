package com.epam.crud.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/*ServletContainerInitializer*/
public class MainWebAppInitializer extends
    WebMvcConfigurationSupport implements WebApplicationInitializer {

  @Override
  public void onStartup(ServletContext servletContext) {
    AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();

    context.register(ApplicationConfig.class);
    servletContext.addListener(new ContextLoaderListener(context));

    ServletRegistration.Dynamic appServlet = servletContext
        .addServlet("mvc", new DispatcherServlet(new GenericWebApplicationContext()));
    appServlet.setLoadOnStartup(1);
    appServlet.addMapping("/");
  }
}
