package cn.phpst.mall.core.enumeration;

public enum LoginType {

    Wechat(1, ""), Email(2, "");
    private Integer value;

    LoginType(Integer value, String description) {
        this.value = value;
    }
}
