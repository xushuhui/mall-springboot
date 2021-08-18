package cn.phpst.mallexample.exception.http;


public class ForbiddenException extends HttpException {
    public ForbiddenException(int code){
        this.code = code;
    }   
}
