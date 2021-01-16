package com.newfeature;

import com.newfeature.config.TestProxyBeanMethodsConfig;
import com.newfeature.pojo.Cat;
import com.newfeature.pojo.Dog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class NewFeatureApplication {

    public static void main(String[] args) {
        // 返回ioc容器
        ConfigurableApplicationContext ioc = SpringApplication.run(NewFeatureApplication.class, args);

        /*String[] beanDefinitionNames = ioc.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }*/

        // TestProxyBeanMethodsConfig

        /*TestProxyBeanMethodsConfig p = ioc.getBean(TestProxyBeanMethodsConfig.class);

        Cat cat = p.cat();
        Cat cat2 = p.cat();
        Dog dog = p.dog();

        System.out.println(dog.testName);

        System.out.println("cat == cat2 : " + (cat2 == cat));*/

        System.out.println(ioc.containsBean("dog"));
//        Dog bean = ioc.getBean(Dog.class);
//        bean.getTestName();
//        System.out.println(bean.testName);

        Dog dog = (Dog) ioc.getBean("dog");
        System.out.println(dog);
    }

}
