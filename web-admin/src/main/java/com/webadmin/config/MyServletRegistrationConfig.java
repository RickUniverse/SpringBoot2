package com.webadmin.config;

import com.webadmin.filter.MyFilter;
import com.webadmin.listener.MyServletContextListener;
import com.webadmin.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author lijichen
 * @date 2021/1/14 - 17:54
 */
@Configuration(proxyBeanMethods = true) // 保证始终是单实例的
public class MyServletRegistrationConfig {

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new MyServlet(),"/myservlet","/my");
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean<MyFilter> myFilterFilterRegistrationBean = new FilterRegistrationBean<>();
        myFilterFilterRegistrationBean.setFilter(new MyFilter());
        myFilterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/myservlet","/my","/css/*"));
        return myFilterFilterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean() {
        return new ServletListenerRegistrationBean(new MyServletContextListener());
    }
}
