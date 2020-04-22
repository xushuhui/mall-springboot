package cn.phpst.mall.service.impl;

import cn.phpst.mall.model.GridCategory;
import cn.phpst.mall.repository.GridCategoryRepository;
import cn.phpst.mall.service.GridCategoryService;
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
