package cn.phpst.mallexample.exception.http;

import lombok.Getter;

@Getter

public class HttpException extends RuntimeException {
    protected int code;
    protected String message;

}
