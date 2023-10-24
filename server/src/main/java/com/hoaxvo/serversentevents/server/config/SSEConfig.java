package com.hoaxvo.serversentevents.server.config;


import com.hoaxvo.serversentevents.server.servelet.SSEServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SSEConfig {

    @Bean
    public ServletRegistrationBean<SSEServlet> sseServletRegistrationBean() {
        ServletRegistrationBean<SSEServlet> registrationBean = new ServletRegistrationBean<>(new SSEServlet());
        registrationBean.addUrlMappings("/sse");
        registrationBean.setLoadOnStartup(1);
        return registrationBean;
    }
}