package cn.phpst.mallexample.service;


import cn.phpst.mallexample.model.Activity;

import java.util.Optional;

public interface ActivityService {
    Optional<Activity> findByName(String name);
}
