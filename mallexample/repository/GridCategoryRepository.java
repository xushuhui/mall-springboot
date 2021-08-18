package cn.phpst.mallexample.repository;

import cn.phpst.mallexample.model.GridCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GridCategoryRepository extends JpaRepository<GridCategory, Integer> {
}
