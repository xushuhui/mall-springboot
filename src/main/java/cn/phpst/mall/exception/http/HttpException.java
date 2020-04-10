package cn.phpst.mall.exception.http;

import lombok.Getter;

@Getter

public class HttpException extends RuntimeException {
    protected int code;
    protected String message;

}
