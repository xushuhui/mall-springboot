package cn.phpst.mall.service;

import cn.phpst.mall.model.Category;

import java.util.List;
import java.util.Map;

public interface CategoryService {
    List<Category> getAllRoots();

    List<Category> getByParentId();

    Map<Integer, List<Category>> getAll();
}
