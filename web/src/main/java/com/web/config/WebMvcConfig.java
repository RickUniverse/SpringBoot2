package com.web.config;

import com.web.converter.MyMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.accept.ParameterContentNegotiationStrategy;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lijichen
 * @date 2021/1/12 - 16:47
 */
@Configuration(proxyBeanMethods = false)
public class WebMvcConfig {
    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
        // 此时hidden中的默认_method 就变成了_m
        hiddenHttpMethodFilter.setMethodParam("_m");
        return hiddenHttpMethodFilter;
    }

    // 启用矩阵变量
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer(){

            /**
             * 自定义内容协商策略
             *  ?format=mytype
             * @param configurer
             */
            @Override
            public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
                Map<String, MediaType> mediaTypeMap = new HashMap<>();
                mediaTypeMap.put("json",MediaType.APPLICATION_JSON);
                mediaTypeMap.put("xml", MediaType.APPLICATION_XML);
                mediaTypeMap.put("mytype",MediaType.parseMediaType("application/my-type"));
                ParameterContentNegotiationStrategy negotiationStrategy = new ParameterContentNegotiationStrategy(mediaTypeMap);

                // 添加基于请求头的
                HeaderContentNegotiationStrategy headerStrategy = new HeaderContentNegotiationStrategy();

                configurer.strategies(Arrays.asList(negotiationStrategy,headerStrategy));
            }

            // 增加自己的messageconverter
            @Override
            public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
                converters.add(new MyMessageConverter());
            }

            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                UrlPathHelper urlPathHelper = new UrlPathHelper();
                // 修改为不直接忽略 ; 符号后面的内容
                urlPathHelper.setRemoveSemicolonContent(false);
                configurer.setUrlPathHelper(urlPathHelper);
            }

            // 添加converter
            @Override
            public void addFormatters(FormatterRegistry registry) {
               registry.addConverter(new Converter<String, Object>() {
                   @Override
                   public Object convert(String s) {
                       // 编写转换规则
                       return null;
                   }
               });
            }
        };
    }
}
