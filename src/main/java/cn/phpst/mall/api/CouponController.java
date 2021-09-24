package cn.phpst.mall.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/coupon")
public class CouponController {
    
     @GetMapping("/pay/order/{id}")
     public String getByCategory(@PathVariable(name="cid") Long cid) {
         return "payment";
     }
        @GetMapping("/whole_store")
     public String getWholeStore() {
         return "payment";
     }
        @GetMapping("/myselft/by/status/{status}")
     public String getMyself(@PathVariable(name="status") Long status) {
         return "payment";
     }
        @GetMapping("/myselft/available/with_category")
     public String getAvailable() {
         return "payment";
     }
      @PostMapping("/collect/{id}")
     public String collect() {
         return "payment";
     }

    //POST coupon/collect/{id}
}
