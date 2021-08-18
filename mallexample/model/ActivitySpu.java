package cn.phpst.mallexample.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Getter
@Setter
public class ActivitySpu  extends BaseEntity {
    @Id
    private Integer id;

    private Integer activityId;
    private Integer spuId;
    private Integer participation;
}