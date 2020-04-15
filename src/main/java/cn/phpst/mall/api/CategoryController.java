package cn.phpst.mall.api;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))

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
