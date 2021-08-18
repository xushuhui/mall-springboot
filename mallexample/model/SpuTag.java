package cn.phpst.mallexample.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class SpuTag {
    @Id
    private Integer id;
   private Integer spuId;
      private Integer tagId;
}