package cn.phpst.mall.exception.http;


public class ServerErrorException extends HttpException {
    public ServerErrorException(int code){
        this.code = code;
    }   
}
