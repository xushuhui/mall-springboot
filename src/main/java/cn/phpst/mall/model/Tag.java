package cn.phpst.mall.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Tag extends BaseEntity {
    @Id
    private Integer id;
    private String title;
    private String description;
    private Short highlight;
    private Short type;

}