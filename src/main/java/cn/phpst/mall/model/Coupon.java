package cn.phpst.mall.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@Where(clause = "delete_time is null ")
public class Coupon extends BaseEntity {
    @Id
    private Long id;
    private String title;
    private String description;
    private Date startTime;
    private Date endTime;
    private BigDecimal fullMoney;
    private BigDecimal minus;
    private BigDecimal rate;
    private Short type;
    private Integer valitiy;
    private Long activityId;
    private String remark;
    private Short wholeStore;
}