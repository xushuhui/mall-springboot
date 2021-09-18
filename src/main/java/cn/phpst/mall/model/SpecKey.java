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
public class SpecKey extends BaseEntity {
    @Id
    private Long id;
    private String name;
    private String unit;
    private Short standard;
    private String description;
}