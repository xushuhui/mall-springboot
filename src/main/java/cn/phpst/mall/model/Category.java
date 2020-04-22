package cn.phpst.mall.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Category extends BaseEntity {
    @Id
    private Integer id;
    private String name;
    private String description;
    private Boolean isRoot;
    private String img;
    private Integer parentId;
    private Integer index;
//    private List<Coupon> couponList;
}
