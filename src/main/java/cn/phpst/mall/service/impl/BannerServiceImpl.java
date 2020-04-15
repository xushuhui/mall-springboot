package cn.phpst.mall.service.impl;

import cn.phpst.mall.model.Banner;
import cn.phpst.mall.repository.BannerRepository;
import cn.phpst.mall.service.BannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))

public class BannerServiceImpl implements BannerService {
    private final BannerRepository bannerRepository;


    @Override
    public Banner getByName(String name){
        return bannerRepository.findOneByName(name);
    }
    @Override
    public Banner getById(Integer id){
        return bannerRepository.findOneById(id);
    }

}
