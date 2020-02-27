package com.xianyu.product.client;

import com.xianyu.pojo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "product-service")
public interface ProductClient {
    @GetMapping("/findById/{pid}")
    public Product findById(@PathVariable("pid") String pid);
    @RequestMapping("/update")
    int update(@RequestBody Product product);
}
