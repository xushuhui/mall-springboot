package cn.phpst.mall.vo;

import cn.phpst.mall.model.Category;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
public class CategoryPureVO {
    private Integer id;
    private String name;
    private Boolean isRoot;
    private String img;
    private Integer parentId;
    private Integer index;

    public CategoryPureVO(Category category) {
        BeanUtils.copyProperties(category, this);
    }
}
