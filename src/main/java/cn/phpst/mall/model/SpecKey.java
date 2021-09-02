package cn.phpst.mall.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class SpecKey extends BaseEntity {
    @Id
    private Long id;
    private String name;
    private String unit;
    private Short standard;
    private String description;
}