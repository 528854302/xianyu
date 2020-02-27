package com.xianyu.controller;

import com.xianyu.dto.Result;
import com.xianyu.pojo.Order;
import com.xianyu.service.UserServiceImpl;
import com.xianyu.user.service.UserService;
import org.springframework.web.bind.annotation.*;
import com.xianyu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/selectBySno/{sno}")
    public User findByUserName(@PathVariable("sno") String sno){
        return userService.findBySno(sno);
    }

    @PostMapping("/insert")
    public Result insert(@RequestBody User user){
        return userService.insert(user);
    }
    @RequestMapping("/update")
    public int updateByPrimaryKey(@RequestBody User user){
        return userService.update(user);
    }
}
