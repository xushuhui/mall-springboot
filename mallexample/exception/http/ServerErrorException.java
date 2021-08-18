package cn.phpst.mallexample.exception.http;


public class ServerErrorException extends HttpException {
    public ServerErrorException(int code){
        this.code = code;
    }   
}
