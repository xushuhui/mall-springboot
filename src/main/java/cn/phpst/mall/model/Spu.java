package cn.phpst.mall.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Spu extends BaseEntity {
    @Id
    private Integer id;
    private String title;
    private String subtitle;
    private Integer categroyId;
    private Integer rootCategoryId;
    private Boolean online;
    private String price;
    private Integer sketchSpecId;
    private Integer defaultSkuId;
    private String img;
    private String discountPrice;
    private String description;
    private String tags;
    private String forThemeImg;
     private String spuThemeImg;

}
