package cn.phpst.mall.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Where(clause = "delete_time is null ")
public class ActivityCoupon extends BaseEntity {
    @Id
    private Long id;

    private Long couponId;
    private Long activityId;

}
