package com.xianyu;

import com.xianyu.mapper.PcollectMapper;
import com.xianyu.mapper.ProductMapper;
import com.xianyu.pojo.Product;
import com.xianyu.product.service.ProductService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.plaf.synth.SynthSpinnerUI;
import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Test {
    @Autowired
    ProductMapper mapper;

    @Autowired
    ProductService service;
    @org.junit.Test
    public void test(){
        System.out.println(service.findCollect("2017101866"));
    }
}
