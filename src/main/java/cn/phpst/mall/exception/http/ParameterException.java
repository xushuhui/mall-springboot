package cn.phpst.mall.exception.http;


import org.springframework.http.HttpStatus;

public class ParameterException extends HttpException {
    public ParameterException(int code) {
        this.code = code;
        this.httpStatus = HttpStatus.BAD_REQUEST.value();
    }
}
