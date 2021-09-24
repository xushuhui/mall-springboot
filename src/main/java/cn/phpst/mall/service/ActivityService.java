package cn.phpst.mall.service;

import cn.phpst.mall.model.Activity;
import cn.phpst.mall.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityService  {
    @Autowired
    private ActivityRepository activityRepository;

    public Activity getByName(String name) {
        return activityRepository.findByName(name);
    }
}