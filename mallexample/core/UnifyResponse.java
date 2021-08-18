package cn.phpst.mallexample.core;

public class UnifyResponse {
    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public UnifyResponse(int code, String message) {

        this.code = code;
        this.message = message;
    }
}
