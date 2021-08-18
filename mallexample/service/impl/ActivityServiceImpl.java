package cn.phpst.mallexample.service.impl;

import cn.phpst.mallexample.model.Activity;
import cn.phpst.mallexample.repository.ActivityRepository;
import cn.phpst.mallexample.service.ActivityService;
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