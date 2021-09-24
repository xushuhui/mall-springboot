
package cn.phpst.mall.service;

import cn.phpst.mall.core.LocalUser;
import cn.phpst.mall.model.Order;
import cn.phpst.mall.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class WechatPaymentService {
    @Autowired
    private OrderRepository orderRepository;

    public Map<String, String> preOrder(Long id) {
        Long uid = LocalUser.getUser().getId();
        Optional<Order> orderOptional = orderRepository.findFirstByUserIdAndId(uid, id);
        return null;
    }
}