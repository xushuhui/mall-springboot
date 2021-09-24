package cn.phpst.mall.service;


import cn.phpst.mall.model.Spu;
import cn.phpst.mall.repository.SpuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class SpuService{
    @Autowired
    private SpuRepository spuRepository;

    public Spu getById(Integer id) {
        return this.spuRepository.findOneById(id);
    }

    public Page<Spu> getLatestPaging(Integer pageNum, Integer count) {
        Pageable page = PageRequest.of(pageNum, count, Sort.by("createTime").descending());
        return this.spuRepository.findAll(page);
    }


    public Page<Spu> getByCategory(Long cid, Boolean isRoot, Integer pageNum, Integer count) {

        Pageable page = PageRequest.of(pageNum, count);

        if (isRoot){
            return this.spuRepository.findByRootCategoryIdOrderByCreateTime(cid,page);
        }else {
            return this.spuRepository.findByCategoryIdOrderByCreateTimeDesc(cid,page);
        }

    }
}