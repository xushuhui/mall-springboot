package cn.phpst.mallexample.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class CouponType extends BaseEntity {
    @Id
    private Integer id;
     private String name;
     private Integer code;
         private String description;
}