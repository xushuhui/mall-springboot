package cn.phpst.mall.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class ActivitySpu extends BaseEntity {
    @Id
    private Long id;

    private Long activityId;
    private Long spuId;
    private Integer participation;
}