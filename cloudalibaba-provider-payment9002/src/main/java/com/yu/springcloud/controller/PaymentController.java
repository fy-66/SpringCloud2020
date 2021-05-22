package com.yu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *@descript 
 *@author yu
 *@date 2021/5/21 23:05
 *@version 1.0
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/nacos/{id}")
    public String getPayment(@PathVariable("id")Integer id){
        log.info("nacos redistry,serverPort:{},id:{}",serverPort,id);
        return "nacos redistry,serverPort: "+serverPort+", id: "+id;
    }
}
