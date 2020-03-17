package cn.phpst.mall.core;

import cn.phpst.mall.exception.http.HttpException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
class GlobalExceptionAdvice {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(code= HttpStatus.INTERNAL_SERVER_ERROR)
    public UnifyResponse handleException(HttpServletRequest req, Exception e) {
        return new UnifyResponse(999, e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(HttpException.class)
    public UnifyResponse handleHttpException(HttpServletRequest req, HttpException e) {
        return new UnifyResponse(e.getCode(), e.getMessage());
    }
} 