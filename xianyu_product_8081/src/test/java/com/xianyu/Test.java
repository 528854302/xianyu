package com.xianyu;

import com.xianyu.dto.PmessageDto;
import com.xianyu.mapper.*;
import com.xianyu.pojo.Pmessage;
import com.xianyu.product.service.PmessageService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Test {
    @Autowired
    PmessageService pmessageService;

    @org.junit.Test
    public void test(){
        List<PmessageDto> ps = pmessageService.findMessageByPid("01", null);
        for (PmessageDto p: ps){
            System.out.println(p.getContent());
        }
    }
}
