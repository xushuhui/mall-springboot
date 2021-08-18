package cn.phpst.mallexample.service.impl;

import cn.phpst.mallexample.model.Banner;
import cn.phpst.mallexample.repository.BannerRepository;
import cn.phpst.mallexample.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerRepository bannerRepository;


    @Override
    public Banner getByName(String name) {
        return bannerRepository.findOneByName(name);
    }

    @Override
    public Banner getById(Integer id) {
        return bannerRepository.findOneById(id);
    }

}
