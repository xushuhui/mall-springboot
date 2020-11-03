package cn.phpst.mall.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class ActivityCategory {
    @Id
    private Integer id;

    private Integer categoryId;
    private Integer activityId;
}