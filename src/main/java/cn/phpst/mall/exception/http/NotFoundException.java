package cn.phpst.mall.exception.http;

import lombok.Getter;

@Getter
public class NotFoundException extends HttpException {
    private int code=10001;
    public NotFoundException(int code, String message) {
        super(code, message);
    }
}
