package com.xianyu.order.service;

import com.xianyu.dto.OrderDto;
import com.xianyu.dto.Result;
import com.xianyu.pojo.Order;

import java.util.List;

public interface OrderService {
    Result insert(Order order);
    List<OrderDto> findBySno(String sno);

    Result deleteById(String id);

    Result pay(String sno,String id);
}
