package cn.phpst.mall.api;

import cn.phpst.mall.model.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")


public class CategoryController {

    @GetMapping("/all")
    public String getAll() {
        return null;
    }

    @GetMapping("/grid/all")
    public String grid() {
        return null;
    }

    @GetMapping("/roots")
    public List<Category> getAllRoots() {
        return null;
    }
}
