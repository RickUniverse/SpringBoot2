package com.webadmin.actuator.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lijichen
 * @date 2021/1/16 - 16:14
 */
@Component
public class MyComHealthIndicator extends AbstractHealthIndicator {

    /**
     * 检查健康状态
     * @param builder
     * @throws Exception
     */
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {

        // mongodb
        Map<String,Object> map = new HashMap<>();

        if (false) {
            builder.status(Status.UP);//正常状态
            map.put("count",1);
            map.put("ms",100);
        } else {
            builder.status(Status.OUT_OF_SERVICE);//正常状态
            map.put("error","链接超时");
            map.put("ms",3000);
        }

        builder.withDetail("code",100)
                .withDetails(map);
    }
}
