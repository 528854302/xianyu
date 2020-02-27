package com.xianyu.service;

import com.xianyu.dto.OrderDto;
import com.xianyu.dto.Result;
import com.xianyu.mapper.OrderMappper;
import com.xianyu.order.service.OrderService;
import com.xianyu.pojo.Order;
import com.xianyu.pojo.Product;
import com.xianyu.pojo.User;
import com.xianyu.product.client.ProductClient;
import com.xianyu.user.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;
@Service
@Transactional
public class OderServiceImpl implements OrderService {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    OrderMappper mappper;
    @Autowired
    ProductClient productClient;
    @Autowired
    UserClient userClient;


    @Override
    public Result<String> insert(Order order) {
        Product product = productClient.findById(order.getPid());
        if (product.getDisplay()==0){
            return new Result(404,"订单提交失败商品已下架或被购买");
        }
        order.setTotal(product.getPrice());
        order.setId(UUID.randomUUID().toString().substring(0,10));
        order.setState(0);
        order.setTime(new Date());
        if (mappper.insert(order)>0){
            product.setDisplay(0);
            productClient.update(product);
            return new Result<String>(order.getId());
        }else {
            return new Result(404,"操作失败");
        }
    }

    @Override
    public List<OrderDto> findBySno(String sno) {

        return mappper.findBySno(sno);
    }


    @Override
    public Result deleteById(String id) {
        Order order = mappper.selectByPrimaryKey(id);
        Product product = productClient.findById(order.getPid());
        if (mappper.deleteByPrimaryKey(id)>0){
            product.setDisplay(1);
            productClient.update(product);
            return new Result();
        }else {
            return new Result(404,"操作失败");
        }
    }


    @Override
    public Result pay(String sno,String id) {
        Order order = mappper.selectByPrimaryKey(id);
        User user = userClient.selectBySno(sno);
        Float balance = user.getBalance()-user.getBalance();
        if (balance<0){
            return new Result(404,"余额不足");
        }
        else {
            user.setBalance(balance);
            userClient.updateByPrimarykey(user);
            order.setState(1);
            mappper.updateByPrimaryKeySelective(order);
            return new Result();
        }
    }
}
