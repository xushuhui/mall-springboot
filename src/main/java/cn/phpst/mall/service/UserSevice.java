package cn.phpst.mall.service;

import cn.phpst.mall.model.User;
import cn.phpst.mall.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSevice {
    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long id) {
        return userRepository.findFirsById(id);
    }
}
