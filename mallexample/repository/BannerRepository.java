package cn.phpst.mallexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.phpst.mallexample.model.Banner;
import org.springframework.stereotype.Repository;

@Repository
public interface BannerRepository extends JpaRepository<Banner,Integer> {
    Banner findOneById(Integer id);
    Banner findOneByName(String name);
}