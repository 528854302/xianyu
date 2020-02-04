package com.xianyu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.xianyu.user.client.UserClient;
import com.xianyu.pojo.User;


@SpringBootTest
@RunWith(SpringRunner.class)
public class TestUserClient {
    @Autowired
    UserClient userClient;
    @Test
    public void test(){
        User user = userClient.selectBySno("2017101866");
        System.out.println(user.getPassword());
    }
}
