package com.xianyu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class IndexController {
    @GetMapping("index")
    public String index(){
        return "index";
    }
    @GetMapping("pinfo")
    public String pinfo(){
        return "product_info";
    }
    @GetMapping("login")
    public String login(){
        return "login";
    }
    @GetMapping("upload")
    public String upload(){
        return "upload";
    }
    @GetMapping("signup")
    public String signup(){
        return "signup";
    }

    @ResponseBody
    @PostMapping("checkUser")
    public String checkUser(@RequestBody Map map){
        System.out.println("********"+map.get("sno")+","+map.get("pass"));
            return "200";
    }
}
