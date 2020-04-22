package cn.phpst.mall.api;

import cn.phpst.mall.exception.http.NotFoundException;
import cn.phpst.mall.model.Category;
import cn.phpst.mall.model.GridCategory;
import cn.phpst.mall.service.CategoryService;
import cn.phpst.mall.service.GridCategoryService;
import cn.phpst.mall.vo.CategoriesAllVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/category")


public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private GridCategoryService gridCategoryService;

    @GetMapping("/all")
    public CategoriesAllVo getAll() {
        Map<Integer, List<Category>> categories = categoryService.getAll();
        return new CategoriesAllVo(categories);
    }

    @GetMapping("/grid/all")
    public List<GridCategory> getGridCategoryList() {
        List<GridCategory> gridCategoryList = gridCategoryService.getGridCategoryList();
        if (gridCategoryList.isEmpty()) {
            throw new NotFoundException(30009);
        }
        return gridCategoryList;
    }

    @GetMapping("/roots")
    public List<Category> getAllRoots() {
        return null;
    }

    @GetMapping("/by/parent/{id}")
    public List<Category> getByParentId() {
        return null;
    }
}
