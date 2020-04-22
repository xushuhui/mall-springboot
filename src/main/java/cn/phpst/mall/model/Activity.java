package cn.phpst.mall.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
public class Activity extends BaseEntity {
    @Id
    private Integer id;
    private String name;
    private String title;
    private String entranceImg;
    private Boolean online;
    private String remark;
    private Date startTime;
    private Date endTime;


}