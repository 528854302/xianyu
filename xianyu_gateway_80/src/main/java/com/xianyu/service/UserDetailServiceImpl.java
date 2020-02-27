package com.xianyu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.xianyu.pojo.User;
import com.xianyu.user.client.UserClient;

import java.util.ArrayList;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    UserClient userClient;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userClient.selectBySno(s);
        org.springframework.security.core.userdetails.User userDetail= new org.springframework.security.core.userdetails.User(s
        ,user.getPassword(),new ArrayList<GrantedAuthority>());
        return userDetail;
    }
}
