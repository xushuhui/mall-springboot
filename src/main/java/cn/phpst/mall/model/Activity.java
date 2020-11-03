package cn.phpst.mall.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Activity extends BaseEntity {
    @Id
    private Integer id;
    private String name;
    private String title;
    private String entranceImg;
  private String internalTopImg;
    private Boolean online;
    private String remark;
 private String description;
    private Date startTime;
    private Date endTime;

    @OneToMany()
    private List<Coupon> coupons;

}