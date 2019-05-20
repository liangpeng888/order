package com.imooc.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MqReceiver {

    //1.手动创建队列 1. @RabbitListener(queues = "myQueue")
    //2.自动创建队列 @RabbitListener(queuesToDeclare = @Queue("myQueue"))
    //2.自动创建队列 Queue 和 Exchange绑定
//            value = @Queue("myQueue"),
//    @RabbitListener(bindings = @QueueBinding(
//            exchange = @Exchange("myExchange")
//    ))
//    public void process(String message){
//        System.out.println("MqReceiver:-------------------------------------"+message);
//
//        log.info("MqReceiver:{}",message);
//    }

    /**
     * 数码供应商服务 接收消息
     * @param message
     */
//    @RabbitListener(bindings = @QueueBinding(
//            exchange = @Exchange("myOrder"),
//            key = "computer",
//            value = @Queue("computerOrder")
//    ))
//    public void processComputer(String message) {
//        System.out.println("computer MqReceiver: ------------------------------------:"+ message);
//        log.info("computer MqReceiver: {}", message);
//    }


    /**
     * 水果供应商服务 接收消息
     * @param message
     */
    /*@RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            key = "fruit",
            value = @Queue("fruitOrder")
    ))
    public void processFruit(String message) {
        log.info("fruit MqReceiver: {}", message);
    }*/
}
