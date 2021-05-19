package com.bsoft.office.sysconfig.mvcconfig;

import com.bsoft.office.sysconfig.filter.DecryptFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration {

    @Value("${cryptFlag}")
    private Integer cryptFlag;

    @Bean
    public FilterRegistrationBean registerFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new DecryptFilter(this.cryptFlag));
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("DecryptFilter");
        registration.setOrder(1);
        return registration;
    }
}
