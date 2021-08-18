package cn.phpst.mallexample.service;

import cn.phpst.mallexample.model.Banner;

public interface BannerService {
    Banner getByName(String name);

    Banner getById(Integer id);
}
