package cn.phpst.mallexample.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class SpecKey extends BaseEntity {
    @Id
    private Integer id;
 private String name;
  private String unit;
  private Short standard;
  private String description;
}