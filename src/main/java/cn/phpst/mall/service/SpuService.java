package cn.phpst.mall.service;

import cn.phpst.mall.model.Spu;
import org.springframework.data.domain.Page;


public interface SpuService {
     Spu getById(Long id);
     Page<Spu> getLatestPaging(Integer page, Integer count);
}
