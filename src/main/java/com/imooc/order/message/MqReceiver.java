package com.imooc.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MqReceiver {

    //手动创建队列 1. @RabbitListener(queues = "myQueue")
    //自动创建队列
    @RabbitListener(queuesToDeclare = @Queue("myQueue"))
    public void process(String message){
        log.info("MqReceiver:{}",message);
    }
}
