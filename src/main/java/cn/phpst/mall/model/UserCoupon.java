package cn.phpst.mall.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class UserCoupon extends BaseEntity {
    @Id
    private Integer id;
}