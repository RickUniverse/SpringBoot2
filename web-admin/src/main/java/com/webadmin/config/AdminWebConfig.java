package com.webadmin.config;

import com.webadmin.interceptor.LoginInterceptor;
import com.webadmin.interceptor.RedisUrlCountInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author lijichen
 * @date 2021/1/14 - 13:45
 */
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

    @Autowired
    RedisUrlCountInterceptor redisUrlCountInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**","/favicon.ico",
                        "/sql");

        registry.addInterceptor(redisUrlCountInterceptor)
                .addPathPatterns("/login","/sql","/main.html");
    }
}
