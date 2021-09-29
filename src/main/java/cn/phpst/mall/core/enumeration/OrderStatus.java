package cn.phpst.mall.core.enumeration;


import java.util.stream.Stream;

public enum OrderStatus {
    ALL(0, "全部"), 
    UNPAID(1, "未支付"),
    PAID(2, "已支付"),
    DELIVERED(3,"已发货")
    FINISHED(4, "已完成"),
    CANCELED(5, "已取消");
   
   PAID_BUY_OUT_OF(21,"已支付，但无货或库存不足")
   DEAL_OUT_OF(22,"已处理缺货但已支付")
    private Integer value;

    OrderStatus(Integer value, String description) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public static OrderStatus toType(int value) {
        return Stream.of(OrderStatus.values()).filter(c -> c.value == value).findAny().orElse(null);
    }
}
