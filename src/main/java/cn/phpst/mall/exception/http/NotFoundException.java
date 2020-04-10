package cn.phpst.mall.exception.http;


public class NotFoundException extends HttpException {
    public NotFoundException(int code){
        this.code = code;
    }   
}
