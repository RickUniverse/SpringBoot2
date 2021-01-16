package com.newfeature.pojo;

/**
 * @author lijichen
 * @date 2021/1/11 - 16:20
 */

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 必须是在ioc容器中才能使用，
 * 必须有set方法
 */
@Component
@ConfigurationProperties(prefix = "test-configuration.properties")
public class Dog {
    public String testName;

    public Dog() {
    }

    public Dog(String testName) {
        this.testName = testName;
    }

    public String getTestName() {
        return testName;
    }

    public Dog setTestName(String testName) {
        this.testName = testName;
        return this;
    }

}
