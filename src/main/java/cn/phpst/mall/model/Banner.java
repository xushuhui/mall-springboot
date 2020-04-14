package cn.phpst.mall.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Banner extends BaseEntity {
    @Id
    private Integer id;

    private String name;
    private String descrition;
    private String img;
    private String title;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "bannerId")
    private List<BannerItem> items;
}
