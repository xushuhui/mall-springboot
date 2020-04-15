package cn.phpst.mall.service.impl;


import cn.phpst.mall.model.Spu;
import cn.phpst.mall.repository.SpuRepository;
import cn.phpst.mall.service.SpuService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))

public class SpuServiceImpl implements SpuService 
{
    private final SpuRepository spuRepository;
    
    @Override
    public Spu getById(Integer id){
        return this.spuRepository.findOneById(id);
    }
    @Override
    public Page<Spu> getLatestPaging(Integer page, Integer count){
        return null;
    }
}