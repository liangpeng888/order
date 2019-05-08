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
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myQueue"),
            exchange = @Exchange("myExchange")
    ))
    public void process(String message){
        log.info("MqReceiver:{}",message);
    }
}
