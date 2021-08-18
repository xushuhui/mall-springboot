package cn.phpst.mallexample.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class SpecValue extends BaseEntity {
    @Id
    private Integer id;
    private String value;
    private Integer specId;
    private String extend;
}