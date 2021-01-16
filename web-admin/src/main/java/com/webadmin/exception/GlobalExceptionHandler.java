package com.webadmin.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author lijichen
 * @date 2021/1/14 - 16:38
 */

/**
 * 处理整个web controller 的异常
 */
@Slf4j
//@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ArithmeticException.class,NullPointerException.class})
    public String handlerException(Exception e) {

        log.error("异常是：{}",e);
        return "login";
    }
}
