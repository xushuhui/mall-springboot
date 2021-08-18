package cn.phpst.mallexample.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class SpuDetailImg extends BaseEntity {
    @Id
    private Integer id;
    private String img;
    private Integer spuId;
    private Integer index;
}
