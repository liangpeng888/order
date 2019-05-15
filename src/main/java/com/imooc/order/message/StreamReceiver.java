package com.imooc.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * 创建通道  并绑定通道
 */
@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {


    /**
     * 接收方
     * @param message
     * @return
     */
    @StreamListener(StreamClient.INPUT)
    @SendTo(StreamClient.OUTPUT)
    public Object processInput(Object message){

        System.out.println("接受消息：----------------------------------"+message);
        log.info("接受消息1:{}"+message);

        return "消费成功！";
    };

    /**
     * 接收反馈
     * @param message
     */
    @StreamListener(StreamClient.OUTPUT)
    public void processOutput(String message){

        System.out.println("反馈消息：----------------------------------"+message);
        log.info("反馈消息:"+message);
    }
}
