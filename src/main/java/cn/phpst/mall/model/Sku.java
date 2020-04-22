package cn.phpst.mall.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Sku extends BaseEntity {
    @Id
    private Integer id;
    private BigDecimal price;
    private BigDecimal discountPrice;
    private Boolean online;
    private String img;
    private String title;
    private Integer spuId;
    private Integer categoryId;
    private Integer rootCategoryId;

    private String specs;
    private String code;
    private Integer stock;

}
