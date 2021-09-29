package cn.phpst.mall.core.enumeration;

public enum LoginType {

    Wechat(1, "微信"), Email(2, "邮箱");
    private Integer value;

    LoginType(Integer value, String description) {
        this.value = value;
    }
}
