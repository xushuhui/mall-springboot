package cn.phpst.mallexample.core;

import cn.phpst.mallexample.exception.http.HttpException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@ControllerAdvice
class GlobalExceptionAdvice {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public UnifyResponse handleException(HttpServletRequest req, Exception e) {
        return new UnifyResponse(999, e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(HttpException.class)
    public UnifyResponse handleHttpException(HttpServletRequest req, HttpException e) {
        return new UnifyResponse(e.getCode(), e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public UnifyResponse handBeanValidation(HttpServletRequest req, MethodArgumentNotValidException e) {
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        String message = this.formatAllErrorMessages(errors);
        return new UnifyResponse(10001, message);
    }

    private String formatAllErrorMessages(List<ObjectError> errors) {
        StringBuffer buffer = new StringBuffer();
        errors.forEach(error -> buffer.append(error.getDefaultMessage()).append(';')
        );
        return buffer.toString();
    }
} 