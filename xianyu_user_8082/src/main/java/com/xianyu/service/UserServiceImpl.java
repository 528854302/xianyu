package com.xianyu.service;

import com.xianyu.mapper.UserMapper;
import com.xianyu.pojo.User;
import com.xianyu.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User findByUsername(String username) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("sno",username);
        List<User> list = userMapper.selectByExample(example);
        if (list.size()>0){
            return list.get(0);
        }else {
            return null;
        }
    }

    @Override
    public User selectOne(User user) {
        return userMapper.selectOne(user);
    }
}
