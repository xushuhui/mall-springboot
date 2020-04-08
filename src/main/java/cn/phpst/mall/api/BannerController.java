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

    @GetMapping("/name/{name}")
    public String getByName(){
        return null;
    }

    @GetMapping("/id/{id}")
    public String getById(){
        return null;
    }
   
}
