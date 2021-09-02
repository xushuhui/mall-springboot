package cn.phpst.mall.api;

import cn.phpst.mall.exception.http.ForbiddenException;
import cn.phpst.mall.exception.http.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.phpst.mall.service.BannerService;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import cn.phpst.mall.model.Banner;

@RestController
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    public BannerService bannerService;


    @GetMapping("/name/{name}")
    public Banner getByName(@PathVariable @NotBlank String name) {
        Banner banner = bannerService.getByName(name);
        if (banner == null) {
            throw new NotFoundException(10001);
        }
        return banner;
    }
    @GetMapping("/id/{id}")
    public Banner getById(@PathVariable @Positive Integer id){
        Banner banner = bannerService.getById(id);
        if(banner == null){
            throw new NotFoundException(10001);
        }
        return banner;
    }
    @GetMapping("/test")
    public void  Test(){
        throw new ForbiddenException(11);
    }
}
