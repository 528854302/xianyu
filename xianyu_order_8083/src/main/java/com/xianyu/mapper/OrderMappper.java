package com.xianyu.mapper;

import com.xianyu.dto.OrderDto;
import com.xianyu.pojo.Order;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface OrderMappper extends Mapper<Order> {
    @Select("SELECT m.`id`,m.`pid`,m.`total`,m.`time`,m.`name`,m.`address`,m.`phone`,p.`pname`,p.`image` \n" +
            "FROM `myorder` m,`product` p \n" +
            "WHERE m.`pid`=p.`pid` \n" +
            "AND m.`sno`=#{sno}")
    List<OrderDto> findBySno(@Param("sno") String sno);
}
