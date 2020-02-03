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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class UserInfoServiceImpl {
    @Autowired
    UserClient userClient;

    public UserInfo getUserInfo(HttpServletRequest request, HttpServletResponse response){
        String userJson = CookieUtils.getCookieValue(request, "userinfo");
        UserInfo userInfo=null;
        if (!StringUtils.isEmpty(userJson)){
            userInfo = (UserInfo) JSONObject.parse(userJson);
            return userInfo;
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null){
            if (authentication instanceof AnonymousAuthenticationToken){
                return null;
            }
            if (authentication instanceof UsernamePasswordAuthenticationToken){
                User user = (User)authentication.getPrincipal();
                com.xianyu.pojo.User user1= userClient.selectOne(user.getUsername());
                userInfo = new UserInfo(user1);
                CookieUtils.setCookie(request,response,"userinfo",JSONObject.toJSONString(userInfo));
                return userInfo;
            }
        }
        return null;
    }


    public String getUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null){
            if (authentication instanceof AnonymousAuthenticationToken){
                return null;
            }
            if (authentication instanceof UsernamePasswordAuthenticationToken){
                User user = (User)authentication.getPrincipal();
                return user.getUsername();
            }
        }
        return null;
    }
}
