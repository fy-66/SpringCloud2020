package com.yu.springcloud.service.impl;

import cn.hutool.core.lang.UUID;
import com.yu.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

/**
 *@descript 
 *@author yu
 *@date 2021/5/19 23:19
 *@version 1.0
 *@EnableBinding(Source.class) 定义消息推送管道
 */
@Slf4j
@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        boolean send = output.send(MessageBuilder.withPayload(serial).build());
        log.info("发送情况，{}，发送消息：{}",send,serial);
        return serial;
    }
}
