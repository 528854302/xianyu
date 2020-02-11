package com.xianyu;

import com.xianyu.dto.PmessageDto;
import com.xianyu.mapper.*;
import com.xianyu.pojo.Pmessage;
import com.xianyu.product.service.PmessageService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Test {
    @Autowired
    PmessageMapper mapper;

    @org.junit.Test
    public void test(){

    }

}
