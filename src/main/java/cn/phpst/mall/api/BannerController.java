package cn.phpst.mall.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/banner")
public class BannerController {
    @GetMapping("/test")
    public String test() {
        return "sss";
    }
    @GetMapping("/id/{id}")
    public String getBannerById(){

    }
    @GetMapping("/name/{name}")
    public String getBannerByName(){

    }
}
