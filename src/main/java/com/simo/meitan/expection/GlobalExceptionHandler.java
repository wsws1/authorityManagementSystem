package com.simo.meitan.expection;

import com.simo.meitan.utils.RestResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 */
//@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value =Exception.class)
    public RestResponse exceptionHandler(Exception e){
        System.out.println("未知异常！原因是:"+e);
        return RestResponse.fail(e.getMessage());
    }
}
