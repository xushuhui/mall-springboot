package cn.phpst.mall.model;

import javax.persistence.*;

@Entity
public class BannerItem  extends BaseEntity{
    @Id    
    private long id;
    private String img;

    private String name;

    private Short type;
   
    private String keyword;

    
    private Long bannerId;
    
}