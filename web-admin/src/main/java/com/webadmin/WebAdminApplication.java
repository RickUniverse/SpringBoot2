package com.webadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

@MapperScan(basePackages = "com.webadmin.mapper")
@ServletComponentScan(basePackages = {"com.webadmin.servlet","com.webadmin.filter","com.webadmin.listener"})//扫描所有servlet
@SpringBootApplication(/*exclude = RedisAutoConfiguration.class*/)//排除掉redis
public class WebAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebAdminApplication.class, args);
    }

}
