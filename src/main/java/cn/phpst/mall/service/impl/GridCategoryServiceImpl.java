package cn.phpst.mallexample.service.impl;

import cn.phpst.mallexample.model.GridCategory;
import cn.phpst.mallexample.repository.GridCategoryRepository;
import cn.phpst.mallexample.service.GridCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GridCategoryServiceImpl implements GridCategoryService {
    @Autowired
    private GridCategoryRepository gridCategoryRepository;

    @Override
    public List<GridCategory> getGridCategoryList() {
        return gridCategoryRepository.findAll();

    }
}
