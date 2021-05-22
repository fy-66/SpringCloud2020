package com.yu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 *@descript 
 *@author yu
 *@date 2021/5/20 10:30
 *@version 1.0
 */
@Component
@Slf4j
@EnableBinding(Sink.class)
public class StreamConsumerController {
    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void receive(Message<String> message){
        log.info("消费者{}号，接收到消息---》{}",serverPort,message.getPayload());
    }

}
