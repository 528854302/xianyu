package com.xianyu.user.service;

import com.xianyu.pojo.User;

public interface UserService {
    User findByUsername(String username);

    User selectOne(User user);
}
