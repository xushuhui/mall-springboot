package cn.phpst.mall.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Where(clause = "delete_time is null ")
public class CouponTemplate extends BaseEntity {
    @Id
    private Long id;
    private String title;
    private String description;
    private BigDecimal fullMoney;
    private BigDecimal minus;
    private BigDecimal discount;
    private Short type;

}