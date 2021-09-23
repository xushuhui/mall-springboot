package cn.phpst.mall.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Where(clause = "delete_time is null and online=1")
public class Activity extends BaseEntity {
    @Id
    private Long id;
    private String name;
    private String title;
    private String entranceImg;
    private String internalTopImg;
    private Boolean online;
    private String remark;
    private String description;
    private Date startTime;
    private Date endTime;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "activityId")
    private List<Coupon> couponList;

}