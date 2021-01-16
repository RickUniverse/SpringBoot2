package com.newfeature.config;

import ch.qos.logback.core.db.DBHelper;
import com.newfeature.pojo.Cat;
import com.newfeature.pojo.Dog;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @author lijichen
 * @date 2021/1/11 - 16:18
 */
/**
 * proxyBeanMethods = false: lite模式
 *      如果只是单纯, 的获取bean，再这个配置类里面，没有彼此依赖的需要是单实例的bean，就建议设置为false
 *      启动时效率速度快
 * proxyBeanMethods = true: full模式：依赖注入
 *      如果该配置类中bean彼此会需要到各自的组件，例如，配置数据源跟mybatis的时候，则需要设置为true，
 *      这样就能保证获取，的都是同一个bean，但每次都需要判断容器中是否有该bean，启动时效率低
 *
 */
@Configuration(proxyBeanMethods = false)
//@Import({Dog.class, DBHelper.class})// 向容器中导入这两个组件，默认组件名是全类名
@ImportResource({"classpath:applicationContent.xml"})//导入xml配置
/**
 * 必须是在ioc容器中才能使用，
 * 必须有set方法
 * 配置类使用@EnableConfigurationProperties
 *      开启Dog的属性配置功能，Dog类不需要加@Component之类的注解了
 *      把这个组件导入到容器中
 */
@EnableConfigurationProperties(Dog.class)
public class TestProxyBeanMethodsConfig {

    private String testName;

    public String getTestName() {
        return testName;
    }

    public TestProxyBeanMethodsConfig setTestName(String testName) {
        this.testName = testName;
        return this;
    }

    public void defaultMethod() {
        System.out.println("--------------");
    }



    /*@Bean
    public Dog dog() {
        //如果有依赖，proxyBeanMethods = true 需要时true
//        Cat cat = cat();
        System.out.println(testName);
        return new Dog();
    }*/

    /*@Bean
    public Cat cat() {
        System.out.println(testName);
        return new Cat();
    }*/
}
