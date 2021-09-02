package cn.phpst.mall.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class SaleExplain extends BaseEntity {
    @Id
    private Long id;
    private Short fixed;
    private String text;
    private Integer index;
    private Long spuId;
    private Long replaceId;
}