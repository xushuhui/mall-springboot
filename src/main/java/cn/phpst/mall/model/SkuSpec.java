package cn.phpst.mall.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class SkuSpec extends BaseEntity {
    @Id
    private Integer id;

}