package com.web.converter;

import com.web.bean.Person;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @author lijichen
 * @date 2021/1/13 - 15:43
 */

/**
 * 自定义Converter
 *  用来返回自定义的数据累型,例如：(xml,json)
 */
public class MyMessageConverter implements HttpMessageConverter<Person> {
    // 是否可读
    @Override
    public boolean canRead(Class<?> aClass, MediaType mediaType) {
        return false;
    }

    // 是否可写
    @Override
    public boolean canWrite(Class<?> aClass, MediaType mediaType) {
        return aClass.isAssignableFrom(Person.class);// 判断是不是可支配的类型
    }

    // 服务器要统计所有MessageConverse都能写出那些内容类型
    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return MediaType.parseMediaTypes("application/my-type");
    }

    @Override
    public Person read(Class<? extends Person> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    // 自定义协议数据的写出
    @Override
    public void write(Person person, MediaType mediaType, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {

        String data = person.getId() + ";" + person.getName();

        // 写出去
        OutputStream body = httpOutputMessage.getBody();
        body.write(data.getBytes());
    }
}
