package cn.phpst.mall.exception.http;

public class HttpException extends RuntimeException {
    private int code;
    private String message;
    public HttpException(int code,String message){
        this.code = code;
        this.message = message;
    }
}
