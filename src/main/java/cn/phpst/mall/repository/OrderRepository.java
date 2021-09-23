package cn.phpst.mall.repository;

import cn.phpst.mall.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Page<Order> findByUserId(Long userId, Pageable pageable);
    Page<Order> findByUserIdAndStatus(Long userId, Integer status, Pageable pageable);
    Page<Order> findByExpiredTimeGreaterThanAndStatusAndUserId(Date expiredTime, Pageable pageable);
    Optional<Order> findFirstByUserIdAndId(Long userId, Long id);
}
