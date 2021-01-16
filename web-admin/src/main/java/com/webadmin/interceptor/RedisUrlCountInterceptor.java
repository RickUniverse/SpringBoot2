package com.webadmin.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lijichen
 * @date 2021/1/15 - 19:05
 */
@Component
public class RedisUrlCountInterceptor implements HandlerInterceptor {

    // 如果想要注入这个    StringRedisTemplate redisTemplate;
    // 必须是让spring创建该类RedisUrlCountInterceptor, 不能自己new
    @Autowired
    StringRedisTemplate redisTemplate;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();

        // 每次访问url都会加1
        redisTemplate.opsForValue().increment(requestURI);
        return true;
    }
}
