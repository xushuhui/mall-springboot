package cn.phpst.mall.service;

import cn.phpst.mall.core.enumeration.OrderStatus;
import cn.phpst.mall.core.money.IMoneyDiscount;
import cn.phpst.mall.core.money.UpRound;
import cn.phpst.mall.dto.OrderDTO;
import cn.phpst.mall.dto.SkuInfoDTO;
import cn.phpst.mall.exception.http.NotFoundException;
import cn.phpst.mall.exception.http.ParameterException;
import cn.phpst.mall.logic.CouponChecker;
import cn.phpst.mall.logic.OrderChecker;
import cn.phpst.mall.model.*;
import cn.phpst.mall.repository.CouponRepository;
import cn.phpst.mall.repository.OrderRepository;
import cn.phpst.mall.repository.SkuRepository;
import cn.phpst.mall.repository.UserCouponRepository;
import cn.phpst.mall.util.OrderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private SkuRepository skuRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserCouponRepository userCouponRepository;
    @Value("${order.max-sku-limit}")
    private int maxSkuLimit;


    private void writeOffCoupon(Long couponId, Long oid, Long uid) {

    }

    @Transactional
    public Long placeOrder(Long uid, OrderDTO orderDTO, OrderChecker orderChecker) {
        String orderNo = OrderUtil.makeOrderNo();
        Order order = Order.builder().orderNo(orderNo).userId(uid).
                totalPrice(orderDTO.getTotalPrice()).
                totalCount(orderChecker.getTotalCount()).
                finalTotalPrice(orderDTO.getFinalTotalPrice()).
                snapImg(orderChecker.getLeaderImg()).
                snapTitle(orderChecker.getLeaderTitle()).
                status(OrderStatus.UNPAID.getValue()).
                build();

        order.setSnapAddress(orderDTO.getAddress());
        order.setSnapItems(orderChecker.getOrderSkuList());
        orderRepository.save(order);
        //reduce stock
        this.reduceStock(orderChecker);
        //核销coupon
        //延迟队列，未支付自动取消
        return order.getId();
    }

    private void reduceStock(OrderChecker orderChecker) {
        List<OrderSku> orderSkuList = orderChecker.getOrderSkuList();
        for (OrderSku orderSku : orderSkuList) {
            int result = this.skuRepository.reduceStock(orderSku.getId(), orderSku.getCount().longValue());
            if (result != 1) {
                throw new ParameterException(50003);
            }
        }
    }

    public OrderChecker isOk(Long uid, OrderDTO orderDTO) {

        if (orderDTO.getFinalTotalPrice().compareTo(new BigDecimal("0")) <= 0) {
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
            couponChecker = new CouponChecker(coupon, iMoneyDiscount);
        }
        OrderChecker orderChecker = new OrderChecker(orderDTO, skuList, couponChecker, this.maxSkuLimit);
        orderChecker.isOk();
        return orderChecker;
    }
}
