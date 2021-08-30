package cn.phpst.mall.exception.http;


import org.springframework.http.HttpStatus;

public class ForbiddenException extends HttpException{
    public ForbiddenException(int code) {
        this.code = code;
        this.httpStatus = HttpStatus.FORBIDDEN.value();
    }
}
