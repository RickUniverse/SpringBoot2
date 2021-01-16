package com.web.controller;

import com.web.bean.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lijichen
 * @date 2021/1/13 - 16:03
 */
@RestController
public class TestMessageConverter {

    /// Get 请求！！！！！
    @GetMapping("/testMessageConverter")
    public Object testMessageConverter(){
        return new Person(1,"eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
    }
}
