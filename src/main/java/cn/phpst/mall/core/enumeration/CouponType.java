package cn.phpst.mall.core.enumeration;

import java.util.stream.Stream;

public enum CouponType {

    FULL_MINUS(1, "满减券"), FULL_OFF(2, "满减折扣券"), NO_THERSHOLD_MINUS(3, "无门槛减除券");
    private Integer value;

    CouponType(Integer value, String description) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public static CouponType toType(int value) {
        return Stream.of(CouponType.values()).filter(c -> c.value == value).findAny().orElse(null);
    }
}
