package cn.phpst.mall.api;

import cn.phpst.mall.core.LocalUser;
import cn.phpst.mall.core.interceptors.ScopeLevel;
import cn.phpst.mall.model.Coupon;
import cn.phpst.mall.service.CounponService;
import cn.phpst.mall.vo.CouponPureVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

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
        List<CouponPureVO> vos = CouponPureVO.getList(coupons);
        return vos;
    }

    @GetMapping("/whole_store")
    public List<CouponPureVO> getWholeStore() {

        List<Coupon> coupons = counponService.getWholeStoreCoupons();
        if (coupons.isEmpty()) {
            return Collections.emptyList();
        }
        List<CouponPureVO> vos = CouponPureVO.getList(coupons);
        return vos;
    }

    @ScopeLevel
    @GetMapping("/myself/by/status/{status}")
    public String getMyCouponByStatus(@PathVariable(name = "status") Integer status) {

        return "payment";
    }

    @GetMapping("/myself/available/with_category")
    public String getAvailable() {
        return "payment";
    }

    @ScopeLevel
    @PostMapping("/collect/{id}")
    public void collectCoupon(@PathVariable Long id) {
        Long uid = LocalUser.getUser().getId();
        counponService.collectOneCoupon(uid, id);
        return;
    }

    //POST coupon/collect/{id}
}
