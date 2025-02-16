package com.brainwave.lc.config;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class LoveCalculatorApplicationInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        XmlWebApplicationContext webApplicationContext = new XmlWebApplicationContext();
        webApplicationContext.setConfigLocation("classpath:application-config.xml");

        //create dispatcher servlet object
        DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);

        //register dispatcher servlet in servlet context object
        ServletRegistration.Dynamic customDispatcherServlet = servletContext.addServlet("myDispatcherServlet", dispatcherServlet);
        customDispatcherServlet.setLoadOnStartup(1);
        customDispatcherServlet.addMapping("/mywebsite.com/*");
    }
}
