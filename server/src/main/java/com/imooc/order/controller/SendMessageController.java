package com.imooc.order.controller;

import com.imooc.order.dto.OrderDTO;
import com.imooc.order.message.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 发送消息
 */
@RestController
public class SendMessageController {

    @Autowired
    private StreamClient streamClient;

    @GetMapping("/sendMessage")
    public void sendMessage(){

//        streamClient.input().send(MessageBuilder.withPayload("你好！二狗子  123  abc").build());

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId("12345110");
        orderDTO.setBuyerName("二狗子");
        streamClient.input().send(MessageBuilder.withPayload(orderDTO).build());

    }
}
