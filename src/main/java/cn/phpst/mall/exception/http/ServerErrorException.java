package cn.phpst.mall.exception.http;


import org.springframework.http.HttpStatus;

public class ServerErrorException extends HttpException {
    public ServerErrorException(int code){
        this.code = code;
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR.value();
    }   
}
