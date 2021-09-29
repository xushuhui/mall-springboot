package cn.phpst.mall.api;

import cn.phpst.mall.core.interceptors.ScopeLevel;
import cn.phpst.mall.dto.OrderDTO;
import cn.phpst.mall.service.OrderService;
import cn.phpst.mall.vo.OrderIdVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@Validated
public class OrderController {

    @Autowired
    private OrderService orderService;

    @ScopeLevel
    @PostMapping("")
    public OrderIdVO placeOrder(@RequestBody OrderDTO orderDTO) {
        //check order
        //place order
        return null;
    }
}
