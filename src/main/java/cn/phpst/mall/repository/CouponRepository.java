package cn.phpst.mall.repository;

import cn.phpst.mall.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Integer> {
    @Query("select c from Coupon c join c.categoryList ca join Activity a on a.id=a.activityId where ca.id=:cid and " +
            "a.startTime < :now and a.endTime > :now")
    List<Coupon> findByCategory(Long cid, Date now);

    List<Coupon> findByWholeStore(boolean isWholeStore, Date now);

    List<Coupon> findMyAvailable(Long uid, Date now);

    List<Coupon> findMyUsed(Long uid, Date now);

    List<Coupon> findMyExpired(Long uid, Date now);
}
