package com.epam.crud.config;

import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

public class MainWebAppInitializer extends
    WebMvcConfigurationSupport implements WebApplicationInitializer {

  @Override
  public void onStartup(ServletContext servletContext) {
    AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();

    context.register(ApplicationConfig.class);
    servletContext.addListener(new ContextLoaderListener(context));

    ServletRegistration.Dynamic appServlet = servletContext
        .addServlet("mvc", new DispatcherServlet(context));
    appServlet.setLoadOnStartup(1);
    appServlet.addMapping("/");
  }

  @Override
  protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    converters.add(new MappingJackson2HttpMessageConverter());
  }
}
