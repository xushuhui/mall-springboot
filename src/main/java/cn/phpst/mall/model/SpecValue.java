package cn.phpst.mall.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class SpecValue extends BaseEntity {
    @Id
    private Long id;
    private String value;
    private Long specId;
    private String extend;
}