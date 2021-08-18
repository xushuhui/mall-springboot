package cn.phpst.mallexample.repository;

import cn.phpst.mallexample.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer> {
    Optional<Activity> findByName(String name);
}
