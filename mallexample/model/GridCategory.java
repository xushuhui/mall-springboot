package cn.phpst.mallexample.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Where(clause = "delete_time is null")
public class GridCategory extends BaseEntity {
    @Id
    private Integer id;
    private String title;
    private String img;
    private String name;
    private Long categoryId;
    private Long rootCategoryId;
}