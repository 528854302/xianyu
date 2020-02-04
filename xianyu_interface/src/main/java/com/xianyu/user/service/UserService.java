package com.xianyu.user.service;

import com.xianyu.pojo.User;

public interface UserService {
    User findByUsername(String username);


    User findBySno(String sno);

    User selectOne(User user );
}
