package cn.phpst.mall.logic;

import cn.phpst.mall.bo.SkuOrderBO;
import cn.phpst.mall.core.enumeration.CouponType;
import cn.phpst.mall.core.money.IMoneyDiscount;
import cn.phpst.mall.exception.http.ForbiddenException;
import cn.phpst.mall.exception.http.ParameterException;
import cn.phpst.mall.model.Coupon;
import cn.phpst.mall.model.UserCoupon;
import cn.phpst.mall.util.CommonUtil;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class CouponChecker {
    private Coupon coupon;

    private IMoneyDiscount iMoneyDiscount;

    public CouponChecker(Coupon coupon, IMoneyDiscount iMoneyDiscount) {
        this.coupon = coupon;
        this.iMoneyDiscount = iMoneyDiscount;
    }

    public void isOk() {
        Date now = new Date();
        Boolean isInTimeline = CommonUtil.isInTimeLine(now, this.coupon.getStartTime(), this.coupon.getEndTime());
        if (!isInTimeline) {
            throw new ForbiddenException(40007);
        }
    }

    public void finalTotalPriceIsOk(BigDecimal clientFinalTotalPrice, BigDecimal serverTotalPrice) {
        BigDecimal serverFinalTotalPrice;
        switch (CouponType.toType(this.coupon.getType())) {
            case FULL_MINUS:
            case NO_THERSHOLD_MINUS:
                serverFinalTotalPrice = serverTotalPrice.subtract(this.coupon.getMinus());
                if (serverFinalTotalPrice.compareTo(BigDecimal::ZERO) <= 0) {
                    throw new ForbiddenException(50008);
                }
                break;
            case FULL_OFF:
                serverFinalTotalPrice = this.iMoneyDiscount.discount(serverTotalPrice, this.coupon.getRate());
                break;
            default:
                throw new ParameterException(50008);
        }
        if (serverFinalTotalPrice.compareTo(clientFinalTotalPrice) != 0) {
            throw new ForbiddenException(50008);
        }
    }

    public void canBeUsed(List<SkuOrderBO> skuOrderBOList, BigDecimal serverTotalPriced) {
        BigDecimal orderCategoryPrice;
        if (this.coupon.getWholeStore()) {
            orderCategoryPrice = serverTotalPriced;
        }else{
            List<Long> cidList = this.coupon.getCategoryList().stream().map(Category::getId).
            collect(Collectors.toList());
            orderCategoryPrice = this.getSumByCategoryList(skuOrderBOList, cidList);
        }
        this.couponCanBeUsed(orderCategoryPrice);
    }
    private void couponCanBeUsed(BigDecimal orderCategoryPrice) {
        switch (CouponType.toType(this.coupon.getType())) {
           
            case NO_THERSHOLD_MINUS:
               
                break;
            case FULL_OFF:
             case FULL_MINUS:
                if (this.coupon.getFullMoney().compareTo(orderCategoryPrice) > 0) {
                    throw new ForbiddenException(40008);
                }
                break;
            default:
                throw new ParameterException(40009);
        }
    }
    private BigDecimal getSumByCategoryList(List<SkuOrderBO> skuOrderBOList,List<Long> cidList) {
        BigDecimal sum = cidList.stream().
        map(cid -> this.getSumByCategory(skuOrderBOList,cid)).
        reduce(BigDecimal.ZERO, BigDecimal::add).
        orElse(BigDecimal.ZERO);
        return sum;
    }

    private BigDecimal getSumByCategory(List<SkuOrderBO> skuOrderBOList, Long cid) {
        BigDecimal sum = skuOrderBOList.stream()
        .filter(skuOrderBO -> skuOrderBO.getCid().equals(cid))
        .map(SkuOrderBO::getPrice)
        .reduce( BigDecimal::add)
        .orElse(BigDecimal.ZERO);
        return sum;
    }
}
