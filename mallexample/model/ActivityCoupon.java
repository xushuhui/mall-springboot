package cn.phpst.mallexample.model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class ActivityCoupon extends BaseEntity {
    @Id
    private Integer id;

    private Integer couponId;
    private Integer activityId;

}
