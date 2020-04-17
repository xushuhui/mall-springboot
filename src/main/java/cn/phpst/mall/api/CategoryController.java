package cn.phpst.mall.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")


public class CategoryController {
    
    @GetMapping("/all")
    public String all(){
        return null;
    }
    @GetMapping("/grid/all")
    public String grid(){
        return null;
    }
}
