package cn.phpst.mall.service;

import cn.phpst.mall.core.money.IMoneyDiscount;
import cn.phpst.mall.core.money.UpRound;
import cn.phpst.mall.dto.OrderDTO;
import cn.phpst.mall.dto.SkuInfoDTO;
import cn.phpst.mall.exception.http.NotFoundException;
import cn.phpst.mall.exception.http.ParameterException;
import cn.phpst.mall.logic.CouponChecker;
import cn.phpst.mall.model.Coupon;
import cn.phpst.mall.model.Sku;
import cn.phpst.mall.model.UserCoupon;
import cn.phpst.mall.repository.CouponRepository;
import cn.phpst.mall.repository.UserCouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private SkuService skuService;

    @Autowired
    private CouponRepository couponRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserCouponRepository userCouponRepository;

    private void reduceStock(){
        
    }
    public Long placeOrder(Long uid,OrderDTO orderDTO,OrderChecker orderChecker){
        String orderNo = OrderUtil.makeOrderNo();
        Order order = Order.builder().orderNo(orderNo).userId(uid).
        totalPrice(orderDTO.getTotalPrice()).
        totalCount(orderChecker.getTotalCount()).
        finalTotalPrice(orderDTO.getFinalTotalPrice()).
        snapImg(orderChecker.getLeaderImg()).
        snapTitle(orderChecker.getLeaderTitle()).
        status(OrderStatus.UNPAID.value()).
        build();

        order.setSnapAddress(orderDTO.getAddress());
        order.setSnapItems(orderChecker.getOrderSkuList());
        orderRepository.save(order);
        //reduce stock
        //核销coupon
        //延迟队列，未支付自动取消
        return order.getId();
    }

    public void isOk(Long uid, OrderDTO orderDTO) {
        if (orderDTO.getFinalToatalPrice().compareTo(BigDecimal::ZERO) <= 0) {
            throw new ParameterException(50011);
        }

        List<Long> skuIdList = orderDTO.getSkuInfoList().stream().map(SkuInfoDTO::getId).collect(Collectors.toList());
        List<Sku> skuList = skuService.getSkuListByIds(skuIdList);

        Long couponId = orderDTO.getCouponId();
        CouponChecker couponChecker = null;
        if (couponId != null) {
            Coupon coupon = couponRepository.findById(couponId).orElseThrow(() -> new NotFoundException(40004));
            UserCoupon userCoupon = userCouponRepository.findFirstByUserIdAndCouponId(uid, couponId)
                    .orElseThrow(() -> new NotFoundException(50006));
            IMoneyDiscount iMoneyDiscount = new UpRound();
            couponChecker = new CouponChecker(coupon, userCoupon, iMoneyDiscount);
        }
    }
}
