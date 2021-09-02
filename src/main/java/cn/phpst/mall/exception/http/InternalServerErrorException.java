package cn.phpst.mall.exception.http;


import org.springframework.http.HttpStatus;

public class InternalServerErrorException extends HttpException {
    public InternalServerErrorException(int code){
        this.code = code;
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR.value();
    }   
}
