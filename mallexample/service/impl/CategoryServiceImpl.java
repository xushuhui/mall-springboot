package cn.phpst.mallexample.service.impl;

import cn.phpst.mallexample.model.Category;
import cn.phpst.mallexample.repository.CategoryRepository;
import cn.phpst.mallexample.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllRoots() {
        return null;
    }

    @Override
    public List<Category> getByParentId() {
        return null;
    }

    @Override
    public Map<Integer, List<Category>> getAll() {
        List<Category> roots = categoryRepository.findAllByIsRootOrderByIndexAsc(true);
        List<Category> subs = categoryRepository.findAllByIsRootOrderByIndexAsc(false);
        Map<Integer, List<Category>> categories = new HashMap<>();
        categories.put(1, roots);
        categories.put(2, subs);
        return categories;
    }
}
