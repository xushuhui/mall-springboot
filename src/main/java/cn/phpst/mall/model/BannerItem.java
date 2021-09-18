package cn.phpst.mall.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Where(clause = "delete_time is null ")
public class BannerItem extends BaseEntity {
    @Id
    private Long id;
    private String img;

    private String name;

    private Short type;

    private String keyword;

    private Long bannerId;

}