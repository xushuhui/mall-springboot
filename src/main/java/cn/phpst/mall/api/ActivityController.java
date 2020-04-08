package cn.phpst.mall.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.phpst.mall.service.impl.ActivityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private ActivityServiceImpl activityService;

}
