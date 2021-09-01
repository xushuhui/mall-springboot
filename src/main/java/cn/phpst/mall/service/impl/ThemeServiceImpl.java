package cn.phpst.mallexample.service.impl;

import cn.phpst.mallexample.model.Theme;
import cn.phpst.mallexample.repository.ThemeRepository;
import cn.phpst.mallexample.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ThemeServiceImpl implements ThemeService {
    @Autowired
    private ThemeRepository themeRepository;

    @Override
    public Optional<Theme> findByName(String name) {
        return themeRepository.findByName(name);
    }

    @Override
    public List<Theme> findByNames(List<String> names) {
        return themeRepository.findByNames(names);
    }
}
