package cn.phpst.mall.repository;

import cn.phpst.mall.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    Optional<User> findByOpenid(String openid);

    User findFirstById(Long id);

    User findByUnifyUid(Long uuid);
}
