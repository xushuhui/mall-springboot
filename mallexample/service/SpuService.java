package cn.phpst.mallexample.service;

import cn.phpst.mallexample.model.Spu;
import org.springframework.data.domain.Page;


public interface SpuService {
     Spu getById(Integer id);
     Page<Spu> getLatestPaging(Integer page, Integer count);

     Page<Spu> getByCategory(Integer cid, Boolean isRoot, Integer pageNum, Integer count);
}
