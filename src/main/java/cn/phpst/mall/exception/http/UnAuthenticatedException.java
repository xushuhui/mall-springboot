package cn.phpst.mall.exception.http;


import org.springframework.http.HttpStatus;

public class UnAuthenticatedException extends HttpException {
    public UnAuthenticatedException(int code) {
        this.code = code;
        this.httpStatus = HttpStatus.UNAUTHORIZED.value();
    }
}
