package cn.phpst.mall.vo;

import cn.phpst.mall.model.Coupon;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class CouponPureVO {
    private Long id;
    private String title;
    private String description;
    private Date startTime;
    private Date endTime;
    private BigDecimal fullMoney;
    private BigDecimal minus;
    private BigDecimal rate;
    private Integer type;
    private Integer valitiy;//领取有效期

    private String remark;
    private Boolean wholeStore;

    public CouponPureVO(Object[] objects) {
        Coupon coupon = (Coupon) objects[0];
        BeanUtils.copyProperties(coupon, this);
    }

    public CouponPureVO(Coupon coupon) {
        BeanUtils.copyProperties(coupon, this);
    }

    public static List<CouponPureVO> getList(List<Coupon> couponList) {
        List<CouponPureVO> vos = new ArrayList<>();
        return couponList.stream().map(CouponPureVO::new).collect(Collectors.toList());
    }
}
