package cn.phpst.mallexample.api;

import cn.phpst.mallexample.model.Activity;
import cn.phpst.mallexample.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

@RestController
@RequestMapping("/activity")


public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @GetMapping("/name/{name}")
    public Activity getByName(@PathVariable @NotBlank String name) {
        Optional<Activity> activity = activityService.findByName(name);
        return null;
    }

    @GetMapping("/name/{name}/with_spu")
    public Activity getByNameWithSpu(@PathVariable @NotBlank String name) {
        return null;
    }
}
