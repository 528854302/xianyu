package com.xianyu.user.client;

import com.xianyu.dto.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import com.xianyu.pojo.User;

@Component
@FeignClient(value = "user-service")
public interface UserClient {

    @GetMapping("/selectBySno/{sno}")
    User selectBySno(@PathVariable("sno") String sno);

    @RequestMapping("/insert")
    Result insert(@RequestBody User user);

}
