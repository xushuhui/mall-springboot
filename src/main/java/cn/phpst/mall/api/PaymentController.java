package cn.phpst.mall.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")

public class PaymentController {

    @PostMapping("/pay/order/{id}")
    public String preWechatOrder(@PathVariable(name = "id") Long id) {
        return "payment";
    }
    
}
