package com.xianyu.controller;

import com.xianyu.dto.Result;
import com.xianyu.pojo.PageResult;
import com.xianyu.pojo.Product;
import com.xianyu.product.service.ProductService;
import com.xianyu.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductServiceImpl productService;
    @GetMapping("findAll")
    public List<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping("findPage/{page}/{size}")
    public PageResult<Product> findpage(@PathVariable int page,
                                        @PathVariable int size){
        return productService.findpage(page,size);
    }

    @GetMapping("findById/{pid}")
    public Product findById(@PathVariable String pid){
        return productService.findById(pid);
    }

    @PostMapping("save")
    public Result save(@RequestBody Product product){
        return productService.save(product);
    }
}
