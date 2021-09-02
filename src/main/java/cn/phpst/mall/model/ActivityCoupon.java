package cn.phpst.mall.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class ActivityCoupon extends BaseEntity {
    @Id
    private Long id;

    private Long couponId;
    private Long activityId;

}
