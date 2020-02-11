package com.xianyu.controller;

import com.xianyu.dto.PmessageDto;
import com.xianyu.dto.ProductCollectDTO;
import com.xianyu.dto.Result;
import com.xianyu.pojo.PageResult;
import com.xianyu.pojo.Pcollect;
import com.xianyu.pojo.Pmessage;
import com.xianyu.pojo.Product;
import com.xianyu.product.service.PmessageService;
import com.xianyu.product.service.ProductService;
import com.xianyu.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ProductController {
    @Autowired
    ProductServiceImpl productService;
    @Autowired
    PmessageService messageService;

    @GetMapping("/findAll")
    public List<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping("/findPage/{page}/{size}")
    public PageResult<Product> findpage(@PathVariable int page,
                                        @PathVariable int size){
        return productService.findpage(page,size);
    }
    @GetMapping("/findById/{pid}")
    public Product findById(@PathVariable String pid){
        return productService.findById(pid);
    }

    @GetMapping("/collect/{sno}/{pid}")
    public Result collect(@PathVariable("sno") String sno,
                          @PathVariable("pid") String pid){
        return productService.collect(sno,pid);
    }
    @GetMapping("/getCollect/{sno}")
    public List<ProductCollectDTO> getCollect(@PathVariable("sno") String sno){
        return productService.findCollectBySno(sno);
    }

    @PostMapping("/save")
    public Result save(@RequestBody Product product){
        return productService.save(product);
    }

    @GetMapping("/removeCollected/{sno}/{pid}")
    public Result removeCollected(@PathVariable("sno") String sno,
                                  @PathVariable("pid") String pid){
        return productService.removeCollected(sno,pid);
    }
    @PostMapping("/leaveMessage")
    public Result leaveMessage(@RequestBody Map map){

        return messageService.leaveMessage(map.get("sno").toString(),map.get("pid").toString(),
                map.get("content").toString(),map.get("parentid").toString());
    }
    @GetMapping("/getMessage/{pid}/{grade}")
    public List<PmessageDto> getMessage(@PathVariable("pid") String pid,
                                        @PathVariable("grade") String grade){
        return messageService.findMessageByPid(pid,grade);
    }
    @GetMapping("/getMessageByParentId/{parentid}")
    public List<PmessageDto> getMessageByParentId(@PathVariable("parentid") String parentid){
        return messageService.getMessageByParentId(parentid);
    }
}
