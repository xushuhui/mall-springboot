package cn.phpst.mall.core;

public class UnifyResponse {
    private int code;
    private String message;

    public UnifyResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
