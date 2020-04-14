package cn.phpst.mall.service;

import cn.phpst.mall.model.Banner;

public interface BannerService {
    Banner getByName(String name);

    Banner getById(Integer id);
}
