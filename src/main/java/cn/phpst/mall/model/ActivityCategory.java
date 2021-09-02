package cn.phpst.mall.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class ActivityCategory {
    @Id
    private Long id;

    private Long categoryId;
    private Long activityId;
}