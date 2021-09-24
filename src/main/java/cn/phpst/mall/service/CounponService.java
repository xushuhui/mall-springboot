package cn.phpst.mall.service;

import cn.phpst.mall.model.Coupon;
import cn.phpst.mall.repository.ActivityRepository;
import cn.phpst.mall.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CounponService {
    @Autowired
    private CouponRepository couponRepository;
    @Autowired
    private ActivityRepository activityRepository;

    public List<Coupon> getByCategory(Long cid) {
        Date now = new Date();
        return couponRepository.findByCategory(cid, now);
    }

    public List<Coupon> getWholeStoreCoupons() {

        Date now = new Date();
        return couponRepository.findByWholeStore(true, now);
    }

    public List<Coupon> getMyAvailableCoupons(Long uid) {

        Date now = new Date();
        return couponRepository.findMyAvailable(uid, now);
    }

    public List<Coupon> getMyUsedCoupons(Long uid) {

        Date now = new Date();
        return couponRepository.findMyUsed(uid, now);
    }

    public List<Coupon> getMyExpiredCoupons(Long uid) {

        Date now = new Date();
        return couponRepository.findMyExpired(uid, now);
    }
}
