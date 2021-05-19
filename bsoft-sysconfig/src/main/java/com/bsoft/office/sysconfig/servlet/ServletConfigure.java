package com.bsoft.office.sysconfig.servlet;

import ctd.oauth.servlet.consumer.Callback;
import ctd.oauth.servlet.consumer.ConsumerReset;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfigure {

    @Bean
    public ServletRegistrationBean getCallbackServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new Callback());
        bean.addUrlMappings("/oauth/callback");
        return bean;
    }

    @Bean
    public ServletRegistrationBean getResetServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new ConsumerReset());
        bean.addUrlMappings("/oauth/reset");
        return bean;
    }
}
