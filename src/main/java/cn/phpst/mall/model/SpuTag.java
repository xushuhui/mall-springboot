package cn.phpst.mall.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class SpuTag {
    @Id
    private Long id;
    private Long spuId;
    private Long tagId;
}