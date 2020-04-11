package cn.phpst.mall.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.phpst.mall.model.Banner;
import org.springframework.stereotype.Repository;

@Repository
public interface BannerRepository extends JpaRepository<Banner,Long> {
    Banner findOneById(Long id);
    Banner findOneByName(String name);
}