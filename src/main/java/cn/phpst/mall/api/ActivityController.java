package cn.phpst.mall.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.phpst.mall.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
@RestController
@RequestMapping("/activity")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))

public class ActivityController {

    private final ActivityService activityService;


}
