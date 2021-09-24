package cn.phpst.mall.service;

import cn.phpst.mall.model.Theme;
import cn.phpst.mall.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ThemeService {
    @Autowired
    private ThemeRepository themeRepository;

    public Optional<Theme> findByName(String name) {
        return themeRepository.findByName(name);
    }

    public List<Theme> findByNames(List<String> names) {
        return themeRepository.findByNames(names);
    }
}
