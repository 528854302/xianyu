package com.xianyu;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {
    @org.junit.Test
    public void test(){
        String encode = new BCryptPasswordEncoder().encode("123456");
        System.out.println(encode);
    }
}
