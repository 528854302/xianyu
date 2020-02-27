package com.xianyu;

import com.xianyu.dto.OrderDto;
import com.xianyu.dto.Result;
import com.xianyu.mapper.OrderMappper;
import com.xianyu.order.service.OrderService;
import com.xianyu.pojo.Order;
import com.xianyu.pojo.Product;
import com.xianyu.product.client.ProductClient;
import org.aspectj.weaver.ast.Or;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import javax.swing.plaf.synth.SynthSpinnerUI;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Test {
    @Autowired
    OrderService orderService;
    @Autowired
    OrderMappper mappper;

    @org.junit.Test
    public void test(){
        Order order = new Order();
        order.setState(2);
        order.setId("cc7c329e-c");
//        Result insert = orderService.insert(order);
//        System.out.println(insert.getMessage());
//        System.out.println(insert.getCode());
//        mappper.insert(order);
//        List<OrderDto> orderDtoList = mappper.findBySno("2017101866");
//        for (OrderDto orderDto : orderDtoList){
//            System.out.println(orderDto.getPname());
//        }

        int i= mappper.updateByPrimaryKeySelective(order);
        System.out.println(i);
    }
}
