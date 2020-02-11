package com.xianyu.product.service;

import com.xianyu.dto.ProductCollectDTO;
import com.xianyu.dto.Result;
import com.xianyu.pojo.PageResult;
import com.xianyu.pojo.Pcollect;
import com.xianyu.pojo.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(String pid);

    PageResult<Product> findpage(int page, int size);

    Result save(Product product);

    Result collect(String sno,String pid);

    List<ProductCollectDTO> findCollectBySno(String sno);

    Result removeCollected(String sno,String pid);

}
