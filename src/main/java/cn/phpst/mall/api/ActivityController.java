package cn.phpst.mall.api;

import cn.phpst.mall.exception.http.NotFoundException;
import cn.phpst.mall.model.Activity;
import cn.phpst.mall.service.ActivityService;
import cn.phpst.mall.vo.ActivityCouponVO;
import cn.phpst.mall.vo.ActivityPureVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/activity")


public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @GetMapping("/name/{name}")
    public ActivityPureVO getByName(@PathVariable @NotBlank String name) {
        Activity activity = activityService.getByName(name);
        if (activity == null) {
            throw new NotFoundException(40001);
        }
        ActivityPureVO vo = new ActivityPureVO(activity);
        return vo;
    }

    @GetMapping("/name/{name}/with_spu")
    public ActivityCouponVO getByNameWithSpu(@PathVariable @NotBlank String name) {
        Activity activity = activityService.getByName(name);
        if (activity == null) {
            throw new NotFoundException(40001);
        }
        return new ActivityCouponVO(activity);

    }
}
