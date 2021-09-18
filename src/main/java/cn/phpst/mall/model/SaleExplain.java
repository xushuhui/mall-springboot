package cn.phpst.mall.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Where(clause = "delete_time is null ")
public class SaleExplain extends BaseEntity {
    @Id
    private Long id;
    private Short fixed;
    private String text;
    private Integer index;
    private Long spuId;
    private Long replaceId;
}