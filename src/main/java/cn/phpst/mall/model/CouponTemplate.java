package cn.phpst.mall.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class CouponTemplate extends BaseEntity {
    @Id
    private Integer id;
     private String title;
    private String description;
           private BigDecimal fullMoney;
           private BigDecimal minus;
           private BigDecimal discount;
           private Short type;
         
}