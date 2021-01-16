package com.webadmin.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lijichen
 * @date 2021/1/14 - 20:39
 */
@RestController
public class TestDataSource {

    @Autowired
    JdbcTemplate jdbcTemplate;

    Counter counter;

    /**
     * 访问：http://localhost:8080/actuator/metrics
     * @param registry
     */
    public TestDataSource(MeterRegistry registry) {
        counter = registry.counter("userSql.running.count");
    }

    @GetMapping("/sql")
    public Object testSql() {
        counter.increment(); // 每次访问该方法就计数
        return jdbcTemplate.queryForList("select * from tb_employee");
    }
}
