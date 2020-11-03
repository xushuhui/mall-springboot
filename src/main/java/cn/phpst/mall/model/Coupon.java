package cn.phpst.mall.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Coupon extends BaseEntity {
    @Id
    private Integer id;
    private String title;
    private String description;
         private Date startTime;
         private Date endTime;
}