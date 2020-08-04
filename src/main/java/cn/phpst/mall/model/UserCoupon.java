package cn.phpst.mall.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Where(clause = "delete_time is null")
public class UserCoupon extends BaseEntity {
    @Id
    private Integer id;
}