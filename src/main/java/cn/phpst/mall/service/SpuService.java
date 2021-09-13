package cn.phpst.mall.service;

import cn.phpst.mall.model.Spu;
import org.springframework.data.domain.Page;


public interface SpuService {
     Spu getById(Integer id);
     Page<Spu> getLatestPaging(Integer page, Integer count);

     Page<Spu> getByCategory(Long cid, Boolean isRoot, Integer pageNum, Integer count);
}
