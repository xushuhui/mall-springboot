package cn.phpst.mall.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xushuhui
 */
@RestController
@RequestMapping("/category")
public class CategoryController {
    @GetMapping("/all")
    public String all(){

    }
    @GetMapping("/grid/all")
    public String grid(){

    }
}
