package com.xianyu.service;

import com.alibaba.fastjson.JSONObject;
import com.xianyu.dto.UserInfo;
import com.xianyu.user.client.UserClient;
import com.xianyu.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class UserInfoServiceImpl {
    @Autowired
    UserClient userClient;
    User user;
    Authentication authentication;


    public UserInfo getUserInfo(HttpServletRequest request, HttpServletResponse response){
        String userJson = CookieUtils.getCookieValue(request, "userinfo");
        UserInfo userInfo=null;
        if (!StringUtils.isEmpty(userJson)){
            userInfo = (UserInfo) JSONObject.parse(userJson);
            return userInfo;
        }
        authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication==null){
            return null;
        }
        if (userInfo==null){
            getUser();
        }
        userInfo = new UserInfo(userClient.selectBySno(user.getUsername()));
        CookieUtils.setCookie(request,response,"userinfo",JSONObject.toJSONString(userInfo));
        return userInfo;
    }


    public String getUserSno(){
        authentication = SecurityContextHolder.getContext().getAuthentication();
        if (this.authentication == null){
            return null;
        }
        if (user == null){
            getUser();
        }
        return user.getUsername();
    }

    public User getUser(){
        if (authentication != null){
            if (authentication instanceof AnonymousAuthenticationToken){
                return null;
            }
            if (authentication instanceof UsernamePasswordAuthenticationToken){
                user = (User)authentication.getPrincipal();
                return user;
            }
        }
        return null;
    }
}
