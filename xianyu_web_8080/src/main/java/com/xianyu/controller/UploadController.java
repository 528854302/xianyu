package com.xianyu.controller;

import com.xianyu.UploadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

@RestController
public class UploadController {
    @Autowired
    HttpServletRequest request;
    @Autowired
    UploadServiceImpl uploadService;
    @PostMapping("upload")
    public String upload(@RequestParam("file") MultipartFile file){
        return uploadService.upload(file,request);
    }
}
