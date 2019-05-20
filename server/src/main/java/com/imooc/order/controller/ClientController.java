package com.imooc.order.controller;


import com.imooc.order.client.ProductClient;
import com.imooc.order.dataobject.DecreaseStockInput;
import com.imooc.order.dataobject.ProductInfoOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
public class ClientController {

//    @Autowired
//    LoadBalancerClient loadBalancerClient;

    @Autowired
    ProductClient productClient;


//    @Autowired
//    RestTemplate restTemplate;

    @GetMapping("/getProductMsg")
    public String getProductMsg(){

        //第一种调用
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject("http://localhost:8080/msg",String.class);

        //第二种
//        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
//        String url = String.format("http://%s:%s",serviceInstance.getHost(),serviceInstance.getPort()+"/msg");
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject(url,String.class);

        //第三种
//        String response = restTemplate.getForObject("http://PRODUCT/msg",String.class);

        String response = productClient.productMsg();
        log.info("response",response);
       return response;
    }


    @GetMapping("/getProductList")
    public String getProductList(){
        List<ProductInfoOutput> list = productClient.listForOrder(Arrays.asList("164103465734242707"));
        log.info("response",list);
        return "ok";
    }

    @GetMapping("/productDecreaseStock")
    public String decreaseStock(){
        productClient.decreaseStock(Arrays.asList(new DecreaseStockInput("164103465734242707",3)));
        return "ok";
    }
}
