package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lijichen
 * @date 2021/1/12 - 16:04
 */
@Controller
public class TestParamController2 {

    @GetMapping("/goto")
    public String testGoto(HttpServletRequest request) {
        request.setAttribute("msg","success。。。。。。。。。");
        return "forward:/success";
    }

    /**
     * 下面的三个参数都会向request域中保存数据，再forward的请求条件下，请求域中的数据不会消失，
     * redirect则会消失
     * @param map
     * @param model
     * @param request
     * @return
     */
    @GetMapping("/testParams")
    public String testParams(Map<String,String> map,
                             Model model,
                             HttpServletRequest request,
                             HttpServletResponse response) {
        map.put("hellomap","hellomap");
        model.addAttribute("hellomodel","hellomodel");
        request.setAttribute("hellorequest","hellorequest");
        response.addCookie(new Cookie("cookieKey","CookieValue"));
        return "forward:/success";
    }


    /**
     * 测试同一个请求
     * @param msg ： 可以用注解从转发过来的请求中获取attribute的值
     * @param request ： 也可以使用HttpServletRequest 接收
     * @return
     */
    @ResponseBody
    @GetMapping("/success")
    public Object testSuccess(@RequestAttribute(value = "msg",required = false) String msg,
                              HttpServletRequest request,
                              HttpServletResponse response) {
        System.out.println(msg);
        System.out.println(request.getAttribute("msg"));
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("request",request.getAttribute("msg"));


        /**
         * 测试这个方法
         * public String testParams(Map<String,String> map,
         *                              Model model,
         *                              HttpServletRequest request) {
         */
        hashMap.put("hellomap::->",request.getAttribute("hellomap"));
        hashMap.put("hellomodel::->",request.getAttribute("hellomodel"));
        hashMap.put("hellorequest::->",request.getAttribute("hellorequest"));

        return hashMap;
    }

    /**
     * 需要配置再配置类中配置WebMvcConfigurer：
     *                  UrlPathHelper urlPathHelper = new UrlPathHelper();
     *                 // 修改为不直接忽略 ; 符号后面的内容
     *                 urlPathHelper.setRemoveSemicolonContent(false);
     *
     * 请求的路径为：/testMatrix/1;mAge=1;mList=q,w,e/2;mAge=9;mList=a,s,d
     * @param m1Age 获取矩阵变量中的m1Age的值
     * @param m2Age 获取矩阵变量中的m2Age的值
     * @param m1List 获取矩阵变量中的m1List的值
     * @param m2List 获取矩阵变量中的m2List的值
     * @return
     */
    @ResponseBody
    @GetMapping("/testMatrix/{m1}/{m2}")
    public Object test(@MatrixVariable(value = "mAge",pathVar = "m1") String m1Age,
                       @MatrixVariable(value = "mAge",pathVar = "m2") String m2Age,
                       @MatrixVariable(value = "mList",pathVar = "m1") List<String> m1List,
                       @MatrixVariable(value = "mList",pathVar = "m2") List<String> m2List,

                       @PathVariable("m1") String m1,
                       @PathVariable("m1") String m2) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("MatrixVariable:m1Age",m1Age);
        hashMap.put("MatrixVariable:m2Age",m2Age);
        hashMap.put("MatrixVariable:m1List",m1List);
        hashMap.put("MatrixVariable:m2List",m2List);
        hashMap.put("PathVariable:m1",m1);
        hashMap.put("PathVariable:m2",m2);
        return hashMap;
    }
}
