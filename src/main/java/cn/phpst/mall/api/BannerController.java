package cn.phpst.mall.api;

import cn.phpst.mall.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @GetMapping("/test")
    public String test() {
        return "sss";
    }

    @GetMapping("/id/{id}")
    public String getBannerById(){
        return null;
    }
    @GetMapping("/name/{name}")
    public String getBannerByName(){
        return null;
    }
}
