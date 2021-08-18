package cn.phpst.mallexample.api;

import cn.phpst.mallexample.exception.http.NotFoundException;
import cn.phpst.mallexample.model.Category;
import cn.phpst.mallexample.model.GridCategory;
import cn.phpst.mallexample.service.CategoryService;
import cn.phpst.mallexample.service.GridCategoryService;
import cn.phpst.mallexample.vo.CategoriesAllVO;
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
    public CategoriesAllVO getAll() {
        Map<Integer, List<Category>> categories = categoryService.getAll();
        return new CategoriesAllVO(categories);
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
