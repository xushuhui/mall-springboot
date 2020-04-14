package cn.phpst.mall.service.impl;


import cn.phpst.mall.model.Spu;
import cn.phpst.mall.repository.SpuRepository;
import cn.phpst.mall.service.SpuService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class SpuServiceImpl implements SpuService 
{
    private final SpuRepository spuRepository;

    public SpuServiceImpl(SpuRepository spuRepository) {
        this.spuRepository = spuRepository;
    }

    @Override
    public Spu getById(Integer id){
        return this.spuRepository.findOneById(id);
    }
    @Override
    public Page<Spu> getLatestPaging(Integer page, Integer count){
        return null;
    }
}