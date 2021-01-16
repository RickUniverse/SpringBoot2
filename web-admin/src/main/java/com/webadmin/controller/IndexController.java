package com.webadmin.controller;

import com.webadmin.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author lijichen
 * @date 2021/1/13 - 18:58
 */
@Controller
public class IndexController {

    @Autowired
    StringRedisTemplate redisTemplate;

    @GetMapping(value = {"/","/login"})
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(User user,
                          HttpSession session) {
        if (StringUtils.hasLength(user.getUserName()) && StringUtils.hasText(user.getPassword())) {
            session.setAttribute("loginUser",user);
            return "redirect:/main.html";// 重定向到main.html,controller
        } else {
            session.setAttribute("msg","用户名账号或密码格式不正确！");
            return "login";
        }
    }

    @GetMapping("/main.html")
    public String main(HttpSession session, Model model) {
        ValueOperations<String,String> valueOperations = redisTemplate.opsForValue();
        String m1 = valueOperations.get("/main.html");
        String s1 = valueOperations.get("/sql");
        model.addAttribute("mainCount",m1);
        model.addAttribute("sqlCount",s1);
        return "main";
    }
}
