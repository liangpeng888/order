package com.imooc.order.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class EvenController {

    @Value("${env}")
    String str;

    @GetMapping("/printlnStr")
    public String printlnStr(){
        System.out.println(str);
        System.out.println("11111111");
        System.out.println("22222222");
        System.out.println("-------");
        return  str;
    }
}
