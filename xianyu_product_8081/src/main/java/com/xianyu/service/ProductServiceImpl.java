package com.xianyu.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xianyu.dto.Result;
import com.xianyu.mapper.ProductMapper;
import com.xianyu.pojo.CommonCode;
import com.xianyu.pojo.PageResult;
import com.xianyu.pojo.Product;
import com.xianyu.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    ProductMapper mapper;

    @Override
    public List<Product> findAll() {
        return mapper.selectAll();
    }

    @Override
    public Product findById(String pid) {
        return mapper.selectByPrimaryKey(pid);
    }


    @Override
    public PageResult<Product> findpage(int page, int size) {
        if (page<1){
            page=1;
        }
        PageHelper.startPage(page,size);
        Page<Product> products = (Page<Product>) mapper.selectAll();

        return new PageResult<Product>(products.getTotal(),products.getResult());
    }

    @Override
    public Result save(Product product) {
        product.setPid(UUID.randomUUID().toString().substring(0,10));
        product.setDisplay(1);
        product.setTime(new Date());
        int i = mapper.insert(product);
        if (i==0){
            return new Result(CommonCode.FAILED,"操作失败");
        }
        else{ return new Result(CommonCode.OK);}
    }
}
