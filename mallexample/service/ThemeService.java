package cn.phpst.mallexample.service;

import cn.phpst.mallexample.model.Theme;

import java.util.List;
import java.util.Optional;

public interface ThemeService {
    Optional<Theme> findByName(String name);

    List<Theme> findByNames(List<String> names);
}
