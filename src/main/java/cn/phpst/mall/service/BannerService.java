package cn.phpst.mall.service;

import cn.phpst.mall.model.Banner;
import cn.phpst.mall.repository.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BannerService {
    @Autowired
    private BannerRepository bannerRepository;


    public Banner getByName(String name) {
        return bannerRepository.findOneByName(name);
    }

    public Banner getById(Integer id) {
        return bannerRepository.findOneById(id);
    }

}
