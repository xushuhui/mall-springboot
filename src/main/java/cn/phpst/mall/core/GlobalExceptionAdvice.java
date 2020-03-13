package cn.phpst.mall.core;

import cn.phpst.mall.exception.http.HttpException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
class GlobalExceptionAdvice {
    @ExceptionHandler(Exception.class)
    public void handleException(HttpServletRequest req,Exception e){

        System.out.println("GlobalExceptionAdvice.handleException");
    }
    @ExceptionHandler(HttpException.class)
    public void handleHttpException(HttpServletRequest req,HttpException e){
        System.out.println("GlobalExceptionAdvice.handleHttpException");
    }
} 