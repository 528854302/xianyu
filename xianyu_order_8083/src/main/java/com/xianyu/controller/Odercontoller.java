package com.xianyu.controller;

import com.xianyu.dto.OrderDto;
import com.xianyu.dto.Result;
import com.xianyu.order.service.OrderService;
import com.xianyu.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Odercontoller {
    @Autowired
    OrderService orderService;
    @PostMapping("/insert")
    public Result insert(@RequestBody Order order){
        return orderService.insert(order);
    }
    @GetMapping("/findBySno/{sno}")
    public List<OrderDto> findBySno(@PathVariable("sno") String sno){
        return orderService.findBySno(sno);
    }
    @GetMapping("/delete/{id}")
    public Result deleteById(@PathVariable("id") String id){
        return orderService.deleteById(id);
    }
    @GetMapping("/pay/{sno}/{id}")
    public Result pay(@PathVariable("sno") String sno,
                      @PathVariable("id") String id){
        return orderService.pay(sno,id);
    }
}
