package cn.phpst.mallexample.exception.http;


public class NotFoundException extends HttpException {
    public NotFoundException(int code){
        this.code = code;
    }   
}
