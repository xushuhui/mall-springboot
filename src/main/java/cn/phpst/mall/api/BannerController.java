package cn.phpst.mall.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("/rest")
public class BannerController {

    public String test() {
       return "sss";
    }
}
