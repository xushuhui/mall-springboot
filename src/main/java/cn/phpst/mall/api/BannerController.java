package cn.phpst.mall.api;

import cn.phpst.mall.exception.http.ForbiddenException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/banner")
public class BannerController {
    @GetMapping("/test")
    public void  Test(){
        throw new ForbiddenException(11);
    }
}
