package com.newfeature.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.Name;

/**
 * @author lijichen
 * @date 2021/1/16 - 17:30
 */
//@Profile(value = {"other","default"})
@RestController
public class TestProfilerController {

    @Value("${person.name:李四}")
    private String name;

    @Profile(value = "prod")
    @GetMapping("/")
    public Object testProfilerProd() {
        return "hello" + name + "prod";
    }

    @Profile(value = "test")
    @GetMapping("/")
    public Object testProfilerTest() {
        return "hello" + name + "test";
    }

    @Value("${MAVEN_HOME}")
    private String MAVEN_HOME;

    @GetMapping("/maven")
    public Object testProfiler2() {
        return "hello" + MAVEN_HOME + "test";
    }
}
