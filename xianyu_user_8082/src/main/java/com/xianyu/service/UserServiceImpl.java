package com.xianyu.service;

import com.xianyu.dto.Result;
import com.xianyu.mapper.UserMapper;
import com.xianyu.pojo.User;
import com.xianyu.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    UserMapper userMapper;

    @Override
    public User findByUsername(String username) {
        return SelectOneByProperty("username",username);
    }

    @Override
    public User findBySno(String sno) {
        return SelectOneByProperty("sno",sno);
    }

    @Override
    public User selectOne(User user) {
        return userMapper.selectOne(user);
    }

    @Override
    public Result insert(User user) {
        String sno = user.getSno();
        if (!sno.matches("^20[0-9]{8}$")){
            return new Result(404,"学号格式不正确，正确格式为:2017101800");
        }
        if (userMapper.selectByPrimaryKey(user.getSno())!=null){
            return new Result(404,"该学号已被注册");
        }
        user.setPassword(new  BCryptPasswordEncoder().encode(user.getPassword()));
        user.setBalance(Float.parseFloat("10000"));
        if (userMapper.insert(user)==0){
            return new Result(404,"新增用户失败");
        }
        return new Result();
    }


    public User SelectOneByProperty(String property,String value){
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo(property.toString(),value);
        List<User> list = userMapper.selectByExample(example);
        if (list.size()>0){
            return list.get(0);
        }else {
            return null;
        }
    }

}
