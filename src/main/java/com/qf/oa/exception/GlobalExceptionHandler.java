package com.qf.oa.exception;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author weimin
 * @ClassName GlobalExceptionHandler
 * @Description TODO
 * @date 2019/9/30 10:57
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public String handleUnauthorizedException(UnauthorizedException e){
        System.out.println("异常处理");
        return "auth/no_permission_prompt";
    }
}
