package cn.phpst.mallexample.repository;

import cn.phpst.mallexample.model.Spu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpuRepository extends JpaRepository<Spu,Integer>  {
    Spu findOneById(Integer id);

    Page<Spu> findByCategoryId(Integer cid, Pageable pageable);
}
