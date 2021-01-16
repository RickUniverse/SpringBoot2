package com.webadmin.actuator.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

/**
 * @author lijichen
 * @date 2021/1/16 - 16:47
 */
@Component
@Endpoint(id = "myservice")
public class MyServiceEndpoint {

    // 检查是否添加端点成功：http://localhost:8080/actuator

    @ReadOperation//读操作
    public Map getDockerInfo() {
        return Collections.singletonMap("dockerInfo","docker start .....");
    }

    @WriteOperation//写操作
    public void stopDocker() {
        System.out.println("docker stop....");
    }
}
