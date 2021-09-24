package cn.phpst.mall.service;

import cn.phpst.mall.model.GridCategory;
import cn.phpst.mall.repository.GridCategoryRepository;
import cn.phpst.mall.service.GridCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GridCategoryService {
    @Autowired
    private GridCategoryRepository gridCategoryRepository;

    @Override
    public List<GridCategory> getGridCategoryList() {
        return gridCategoryRepository.findAll();

    }
}
