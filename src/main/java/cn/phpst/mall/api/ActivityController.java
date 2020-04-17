package cn.phpst.mall.api;

import cn.phpst.mall.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activity")


public class ActivityController {
    @Autowired
    private ActivityService activityService;


}
