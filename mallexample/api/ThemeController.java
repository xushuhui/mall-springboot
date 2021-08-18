package cn.phpst.mallexample.api;

import cn.phpst.mallexample.exception.http.NotFoundException;
import cn.phpst.mallexample.model.Theme;
import cn.phpst.mallexample.service.ThemeService;
import cn.phpst.mallexample.vo.ThemePureVO;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/theme")
public class ThemeController {
    @Autowired
    private ThemeService themeService;

    @GetMapping("/by/names")
    public List<ThemePureVO> getThemes(@RequestParam(name = "names") String names) {
        List<String> nameList = Arrays.asList(names.split(","));
        List<Theme> themes = themeService.findByNames(nameList);
        List<ThemePureVO> list = new ArrayList<>();
        themes.forEach(theme -> {
            Mapper mapper = DozerBeanMapperBuilder.buildDefault();
            ThemePureVO vo = mapper.map(theme, ThemePureVO.class);
            list.add(vo);
        });
        return list;
    }

    @GetMapping("/name/{name}/with_spu")
    public Theme getThemeByNameWithSpu(@PathVariable(name = "name") String name,
                                       @RequestParam(defaultValue = "0") Integer start,
                                       @RequestParam(defaultValue = "10") Integer count) {
        Optional<Theme> optionalTheme = this.themeService.findByName(name);
        return optionalTheme.orElseThrow(() -> new NotFoundException(30001));
    }


}
