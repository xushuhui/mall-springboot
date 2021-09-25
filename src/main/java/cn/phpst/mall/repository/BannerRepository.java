package cn.phpst.mall.repository;

import cn.phpst.mall.model.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BannerRepository extends JpaRepository<Banner, Long> {
    Banner findOneById(Integer id);

    Banner findOneByName(String name);
}