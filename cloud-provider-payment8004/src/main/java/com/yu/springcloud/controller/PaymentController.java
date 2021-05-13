package com.yu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 *@descript PaymentController
 *@author yu
 *@date 2021/5/9 10:55
 *@version 1.0
 */
@RestController
public class PaymentController {


    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/payment/zk")
    public String paymentZk(){
        return "springCloud with zookeeper:"+serverPort+"\t"+ UUID.randomUUID();
    }

}
