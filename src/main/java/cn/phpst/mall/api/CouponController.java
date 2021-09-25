package cn.phpst.mall.api;

import cn.phpst.mall.core.LocalUser;
import cn.phpst.mall.core.enumeration.CouponStatus;
import cn.phpst.mall.core.interceptors.ScopeLevel;
import cn.phpst.mall.exception.http.ParameterException;
import cn.phpst.mall.model.Coupon;
import cn.phpst.mall.service.CounponService;
import cn.phpst.mall.vo.CouponCategoryVO;
import cn.phpst.mall.vo.CouponPureVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/coupon")
public class CouponController {

    @Autowired
    private CounponService counponService;

    @GetMapping("/pay/order/{id}")
    public List<CouponPureVO> getByCategory(@PathVariable Long cid) {
        List<Coupon> coupons = counponService.getByCategory(cid);
        if (coupons.isEmpty()) {
            return Collections.emptyList();
        }
        return CouponPureVO.getList(coupons);
    }

    @GetMapping("/whole_store")
    public List<CouponPureVO> getWholeStore() {

        List<Coupon> coupons = counponService.getWholeStoreCoupons();
        if (coupons.isEmpty()) {
            return Collections.emptyList();
        }
        return CouponPureVO.getList(coupons);
    }

    @ScopeLevel
    @GetMapping("/myself/by/status/{status}")
    public List<CouponPureVO> getMyCouponByStatus(@PathVariable(name = "status") Integer status) {
        Long uid = LocalUser.getUser().getId();
        List<Coupon> coupons;
        switch (CouponStatus.toType(status)) {
            case AVAILABLE:
                coupons = counponService.getMyAvailableCoupons(uid);
                break;
            case USED:
                coupons = counponService.getMyUsedCoupons(uid);
                break;
            case EXPIRED:
                coupons = counponService.getMyExpiredCoupons(uid);
                break;
            default:
                throw new ParameterException(40001);
        }

        return CouponPureVO.getList(coupons);
    }

    @GetMapping("/myself/available/with_category")
    public List<CouponCategoryVO> getUserCouponWithCategroy() {
        Long uid = LocalUser.getUser().getId();
        List<Coupon> coupons = counponService.getMyAvailableCoupons(uid);
        if (coupons.isEmpty()) {
            return Collections.emptyList();
        }
        return coupons.stream().map(coupon -> {
            CouponCategoryVO vo = new CouponCategoryVO(coupon);
            return vo;
        }).collect(Collectors.toList());
    }

    @ScopeLevel
    @PostMapping("/collect/{id}")
    public void collectCoupon(@PathVariable Long id) {
        Long uid = LocalUser.getUser().getId();
        counponService.collectOneCoupon(uid, id);
        //TODO success response
        return;
    }

}
