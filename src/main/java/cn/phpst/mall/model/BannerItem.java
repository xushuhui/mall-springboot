package cn.phpst.mall.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class BannerItem  extends BaseEntity{
    @Id    
    private long id;
    private String img;

    private String name;

    private Short type;
   
    private String keyword;

    private Long bannerId;
    
}