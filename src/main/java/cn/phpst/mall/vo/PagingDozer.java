package cn.phpst.mall.vo;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class PagingDozer<T,K> extends Paging {
    @SuppressWarnings("unchecked")
    public PagingDozer(Page<T> tPage,Class<K> kClass){
        this.initPageParameters(tPage);
        List<T> tList = tPage.getContent();
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        List<K> kList = new ArrayList<>();
        tList.forEach(t->{
            K vo = mapper.map(t,kClass);
            kList.add(vo);
        });
        this.setItems(kList);
    }
}
