package com.webadmin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author lijichen
 * @date 2021/1/14 - 16:56
 */
//@ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "用户数量太多！")
public class UserTooManyException extends RuntimeException{

    public UserTooManyException() {
    }
    public UserTooManyException(String message) {
        super(message);
    }
}
