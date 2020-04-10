package cn.phpst.mall.exception.http;


public class ForbiddenException extends HttpException {
    public ForbiddenException(int code){
        this.code = code;
    }   
}
