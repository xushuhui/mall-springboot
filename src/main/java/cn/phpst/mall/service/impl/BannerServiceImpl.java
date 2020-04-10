package cn.phpst.mall.service.impl;

import cn.phpst.mall.model.Banner;
import cn.phpst.mall.repository.BannerRepository;
import cn.phpst.mall.service.BannerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerRepository bannerRepository;
    @Override
    public Banner getByName(String name){
        return bannerRepository.findOneByName(name);
    }
    @Override
    public Banner getById(Long id){
        return bannerRepository.findOneById(id);
    }

}
