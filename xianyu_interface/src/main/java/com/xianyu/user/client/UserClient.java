package com.xianyu.user.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.xianyu.pojo.User;
@Component
@FeignClient(value = "user-service")
public interface UserClient {

    @GetMapping("/selectBySno/{sno}")
    User selectBySno(@PathVariable("sno") String sno);

}
