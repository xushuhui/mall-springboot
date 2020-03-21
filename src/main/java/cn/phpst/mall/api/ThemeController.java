package cn.phpst.mall.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/theme")
public class ThemeController {
    @GetMapping("/by/names")
    public String getThemes(){

    }
    @GetMapping("/name/{name}")
    public String getThemeByName(){

    }
}
