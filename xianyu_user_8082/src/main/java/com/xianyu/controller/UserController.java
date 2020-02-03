package com.xianyu.controller;

import com.xianyu.service.UserServiceImpl;
import org.springframework.web.bind.annotation.*;
import com.xianyu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @GetMapping("/selectByUsername/{username}")
    public User findByUserName(@PathVariable("username") String username){
        return userService.findByUsername(username);
    }
    @GetMapping("/selectOne/{username}")
    public User selectOne(@PathVariable("username") String username){
        User user = new User();
        user.setUsername(username);
        return userService.selectOne(user);
    }
}
