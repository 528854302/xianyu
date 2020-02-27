package com.xianyu.user.service;

import com.xianyu.dto.Result;
import com.xianyu.pojo.Order;
import com.xianyu.pojo.User;

public interface UserService {
    User findByUsername(String username);


    User findBySno(String sno);

    User selectOne(User user );

    Result insert(User user);

    int update(User user);
}
