package cn.phpst.mall.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ActivityPureVO {
    private Integer id;
    private String name;
    private String title;
    private String entranceImg;
    private Boolean online;
    private String remark;
    private Date startTime;
    private Date endTime;
}
