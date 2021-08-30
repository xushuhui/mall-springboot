package cn.phpst.mall.exception.http;

import org.springframework.http.HttpStatus;

public class NotFoundException extends HttpException{
    public NotFoundException( int code) {
        this.code = code;
        this.httpStatus = HttpStatus.NOT_FOUND.value();
    }
}
