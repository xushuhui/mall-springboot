package cn.phpst.mallexample.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class SaleExplain extends BaseEntity {
    @Id
    private Integer id;
    private Short fixed;
    private String text;
    private Integer index;
    private Integer spuId;
    private Integer replaceId;
}