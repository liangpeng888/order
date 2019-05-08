package com.imooc.order.message;

import com.imooc.order.OrderApplicationTests;
import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.*;

public class MqReceiverTest extends OrderApplicationTests {

//    @Test
//    public void process() {
//    }

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void send() {
        amqpTemplate.convertAndSend("myQueue", "now " + new Date());
    }

//    @Test
//    public void sendOrder() {
//        amqpTemplate.convertAndSend("myOrder", "computer", "now " + new Date());
//    }
}