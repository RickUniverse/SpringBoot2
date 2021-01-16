package com.webadmin.actuator.info;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * @author lijichen
 * @date 2021/1/16 - 16:28
 */
@Component
public class AppInfoInfoContributor implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("msg","good")
                .withDetail("ssfff","wwwwww")
                .withDetails(Collections.singletonMap("yes","no"));
    }
}
