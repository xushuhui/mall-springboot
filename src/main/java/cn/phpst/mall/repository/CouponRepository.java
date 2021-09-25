package cn.phpst.mall.repository;

import cn.phpst.mall.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {
    @Query("select c from Coupon c join c.categoryList ca join Activity a on a.id=c.activityId where ca.id=:cid and " +
            "a.startTime < :now and a.endTime > :now")
    List<Coupon> findByCategory(Long cid, Date now);

    @Query("select c from Coupon c  join Activity a on a.id=c.activityId where c.wholeStore=:isWholeStore and " +
            "a.startTime < :now and a.endTime > :now")
    List<Coupon> findByWholeStore(boolean isWholeStore, Date now);

    @Query("select c from Coupon c join UserCoupon uc on c.id=uc.couponId join User u on u.id=uc.userId where " +
            "uc.status = 1 and u.id = :uid and c.startTime < :now and c.endTime > :now and uc.orderId is null")
    List<Coupon> findMyAvailable(Long uid, Date now);

    @Query("select c from Coupon c join UserCoupon uc on c.id=uc.couponId join User u on u.id=uc.userId where " +
            "uc.status = 2 and u.id = :uid and c.startTime < :now and c.endTime > :now and uc.orderId is not null")
    List<Coupon> findMyUsed(Long uid, Date now);

    @Query("select c from Coupon c join UserCoupon uc on c.id=uc.couponId join User u on u.id=uc.userId where " +
            "uc.status = 2 and u.id = :uid and c.endTime < :now and uc.orderId is  null and uc.status <> 2")
    List<Coupon> findMyExpired(Long uid, Date now);

    Optional<Coupon> findById(Long couponId);

}
