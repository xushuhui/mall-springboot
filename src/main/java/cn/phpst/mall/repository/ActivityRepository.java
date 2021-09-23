package cn.phpst.mall.repository;

import cn.phpst.mall.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer> {
    Activity findByName(String name);
}
