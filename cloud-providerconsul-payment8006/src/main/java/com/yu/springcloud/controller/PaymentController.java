package com.yu.springcloud.controller;

import com.yu.springcloud.entities.Health;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 *@descript 
 *@author yu
 *@date 2021/5/10 19:24
 *@version 1.0
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/actuator/health")
    public Health health(){
        return Health.getHealth();
    }

    @RequestMapping(value = "/payment/consul")
    public String paymentConsul(){
        return "springCloud with consul:"+serverPort+"\t "+ UUID.randomUUID();
    }

}
