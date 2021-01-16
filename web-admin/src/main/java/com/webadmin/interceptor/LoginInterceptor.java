package com.webadmin.interceptor;

/**
 * @author lijichen
 * @date 2021/1/14 - 13:42
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录拦截器
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info("拦截的路径是{}",request.getRequestURI());

        HttpSession session = request.getSession();
        if (session.getAttribute("loginUser")!=null) {
            return true;// 如果已经登录，放行
        }

        request.setAttribute("msg","请登录！");
        request.getRequestDispatcher("/").forward(request,response);// 去登录页面
        return false;//否则不执行后续的方法
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
