package com.bms.service;

import com.bms.dao.UserRepository;
import com.bms.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUserList() {
        return userRepository.findAll();
    }

    public Boolean login(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        Example<User> example = Example.of(user);
        return userRepository.exists(example);
    }

    public void register(User user) throws Exception {
        Example<User> example = Example.of(new User(user.getUsername()));
        if (userRepository.exists(example)) {
            throw new Exception("该用户已注册");
        }
        userRepository.save(user);
    }
}
