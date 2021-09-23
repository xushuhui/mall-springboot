package cn.phpst.mall.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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
    private Integer type;
    private Integer valitiy;//领取有效期
    private Long activityId;
    private String remark;
    private Boolean wholeStore;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "couponList")

    @JoinTable(name = "coupon_category", joinColumns = @JoinColumn(name = "coupon_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categoryList;

    @ManyToOne
    @JoinTable(name = "coupon", joinColumns = @JoinColumn(name = "activity_id"))
    @JoinColumn(name = "activityId")
    private Activity activity;
}