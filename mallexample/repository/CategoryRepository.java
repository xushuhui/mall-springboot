package cn.phpst.mallexample.repository;

import cn.phpst.mallexample.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findAllByIsRootOrderByIndexAsc(Boolean isRoot);
}
