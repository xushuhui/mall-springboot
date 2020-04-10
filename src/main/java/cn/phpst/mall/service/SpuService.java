package cn.phpst.mall.service;

import java.util.List;

import cn.phpst.mall.model.Spu;

public interface SpuService {
     Spu getById(Long id);
     List<Spu> getLatestPaging();
}
