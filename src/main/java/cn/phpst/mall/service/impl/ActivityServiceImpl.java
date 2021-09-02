package cn.phpst.mall.service.impl;

import cn.phpst.mall.model.Activity;
import cn.phpst.mall.repository.ActivityRepository;
import cn.phpst.mall.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityRepository activityRepository;

    @Override
    public Optional<Activity> findByName(String name) {
        return activityRepository.findByName(name);
    }
}