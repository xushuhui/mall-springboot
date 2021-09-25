package cn.phpst.mall.service;

import cn.phpst.mall.core.enumeration.CouponStatus;
import cn.phpst.mall.exception.http.NotFoundException;
import cn.phpst.mall.exception.http.ParameterException;
import cn.phpst.mall.model.Activity;
import cn.phpst.mall.model.Coupon;
import cn.phpst.mall.model.UserCoupon;
import cn.phpst.mall.repository.ActivityRepository;
import cn.phpst.mall.repository.CouponRepository;
import cn.phpst.mall.repository.UserCouponRepository;
import cn.phpst.mall.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CounponService {
    @Autowired
    private CouponRepository couponRepository;
    @Autowired
    private UserCouponRepository userCouponRepository;
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

    public void collectOneCoupon(Long uid, Long couponId) {
        this.couponRepository.findById(couponId)
                .orElseThrow(() -> new NotFoundException(40003));
        Activity activity = this.activityRepository.findByCouponListId(couponId)
                .orElseThrow(() -> new NotFoundException(40010));
        Date now = new Date();
        Boolean isIn = CommonUtil.isInTimeLine(now, activity.getStartTime(), activity.getEndTime());
        if (!isIn) {
            throw new ParameterException(40005);
        }
        this.userCouponRepository.findFirstByUserIdAndCouponId(uid, couponId)
                .ifPresent((uc) -> new ParameterException(40006));
        UserCoupon userCouponNew = UserCoupon.builder()
                .userId(uid).couponId(couponId).status(CouponStatus.AVAILABLE.getValue()).createTime(now)
                .build();
        userCouponRepository.save(userCouponNew);
    }
}
