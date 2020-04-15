package cn.phpst.mall.service.impl;

import cn.phpst.mall.model.Theme;
import cn.phpst.mall.service.ThemeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))

public class ThemeServiceImpl implements ThemeService {
    @Override
    public Theme getByName(String name){
        return null;
    }
}
