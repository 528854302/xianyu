package com.xianyu;

import com.xianyu.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.xianyu.pojo.User;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestUserService {
    @Autowired
    UserServiceImpl userService;
    @Test
    public  void Test(){
        User user = userService.findByUsername("2017101866");
        System.out.println(user.getPassword());
    }
}
