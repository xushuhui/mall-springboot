package cn.phpst.mall.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Where(clause = "delete_time is null and online = 1")
public class Category extends BaseEntity {
    @Id
    private Long id;
    private String name;
    private String description;
    private Boolean isRoot;
    private String img;
    private Long parentId;
    private Short index;
    private Short online;
    private Short level;
//    private List<Coupon> couponList;
}
