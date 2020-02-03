package com.xianyu;

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
    @org.junit.Test
    public void test(){
        Product product= new Product();
        product.setPid("123456");
        product.setSno("2017101866");
        product.setPname("sada");
        product.setTime(new Date());
        product.setLevel(8);
        product.setCategory(1);
        product.setDisplay(1);
        product.setImage("aaaa");
        product.setPrice(20.0);
        int i= mapper.insert(product);
        System.out.println("****************"+i);
    }
}
