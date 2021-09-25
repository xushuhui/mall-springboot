package cn.phpst.mall.core.enumeration;

public enum CouponStatus {
    AVAILABLE(1, "未使用"), USED(2, "已使用"), EXPIRED(3, "过期");
    private Integer value;

    CouponStatus(Integer value, String description) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
