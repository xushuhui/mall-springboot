package cn.phpst.mall.exception.http;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class HttpException extends RuntimeException{
    protected int code;
    protected int httpStatus=500;
}
