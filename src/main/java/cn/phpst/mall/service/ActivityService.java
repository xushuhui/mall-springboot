package cn.phpst.mall.service;


import cn.phpst.mall.model.Activity;

import java.util.Optional;

public interface ActivityService {
    Optional<Activity> findByName(String name);
}
