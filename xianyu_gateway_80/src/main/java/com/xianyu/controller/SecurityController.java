package com.xianyu.controller;

import com.alibaba.fastjson.JSONObject;
import com.xianyu.dto.UserInfo;
import com.xianyu.service.UserInfoServiceImpl;
import com.xianyu.user.client.UserClient;
import com.xianyu.utils.CookieUtils;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
public class SecurityController {

    @Autowired
    UserInfoServiceImpl userInfoService;

    @GetMapping("getUserDetail")
    public UserInfo userInfo(HttpServletRequest request,HttpServletResponse response){
        return userInfoService.getUserInfo(request,response);
    }

    @GetMapping("getUsername")
    public String getUsername(){
        return userInfoService.getUsername();
    }
}
