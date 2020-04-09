package cn.phpst.mall.model;

import javax.persistence.*;
import java.util.List;
@Entity
public class Banner extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private long id;

    @Column(length = 20)
    private String name;
    @Column(length = 100)
    private String descrition;
    @Column(length = 100)
    private String img;
    @Column(length = 20)
    private String title;

    @OneToMany()
    @JoinColumn(name = "bannerId")
    private List<BannerItem> items;
}
