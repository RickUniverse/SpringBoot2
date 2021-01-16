package com.webadmin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@SpringBootTest
class WebAdminApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    DataSource dataSource;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    JedisConnectionFactory jedisConnectionFactory;

    @Test
    void contextLoads() {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from tb_employee");
//        System.out.println(maps);
        System.out.println(dataSource.getClass());
    }

    @Test
    void testRedis() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("hello","hello");

        Object hello = valueOperations.get("hello");
        System.out.println(hello);

        System.out.println(jedisConnectionFactory.getClass());
    }
}
