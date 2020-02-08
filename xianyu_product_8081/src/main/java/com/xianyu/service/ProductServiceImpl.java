package com.xianyu.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xianyu.dto.Result;
import com.xianyu.mapper.PcollectMapper;
import com.xianyu.mapper.ProductMapper;
import com.xianyu.pojo.CommonCode;
import com.xianyu.pojo.PageResult;
import com.xianyu.pojo.Pcollect;
import com.xianyu.pojo.Product;
import com.xianyu.product.service.ProductService;
import org.apache.ibatis.javassist.bytecode.LineNumberAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.rmi.server.ServerNotActiveException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    ProductMapper productMapper;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    PcollectMapper collectMapper;

    @Override
    public List<Product> findAll() {
        return productMapper.selectAll();
    }

    @Override
    public Product findById(String pid) {
        return productMapper.selectByPrimaryKey(pid);
    }


    @Override
    public PageResult<Product> findpage(int page, int size) {
        if (page<1){
            page=1;
        }
        PageHelper.startPage(page,size);
        Page<Product> products = (Page<Product>) productMapper.selectAll();

        return new PageResult<Product>(products.getTotal(),products.getResult());
    }

    @Override
    public Result save(Product product) {
        product.setPid(UUID.randomUUID().toString().substring(0,10));
        product.setDisplay(1);
        product.setTime(new Date());
        int i = productMapper.insert(product);
        if (i==0){
            return new Result(404,"操作失败");
        }
        else{ return new Result();}
    }

    @Override
    public Result collect(String sno, String pid) {
        if (sno==null || pid==null){
            return new Result(404,"获取参数错误");
        }
        Example example = new Example(Pcollect.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("sno",sno);
        criteria.andEqualTo("pid",pid);
        if (collectMapper.selectByExample(example).size()>0){
            return new Result(200,"你已收藏该商品");
        }
        Pcollect pcollect = new Pcollect(sno,pid);
        pcollect.setId(UUID.randomUUID().toString().substring(0,10));
        pcollect.setTime(new Date());
        if (collectMapper.insert(pcollect)>0){
            return new Result();
        }
        return new Result(404,"操作失败");
    }


    @Override
    public List<Pcollect> findCollect(String sno) {

        Example example = new Example(Pcollect.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("sno",sno);
        return collectMapper.selectByExample(example);
    }
}
