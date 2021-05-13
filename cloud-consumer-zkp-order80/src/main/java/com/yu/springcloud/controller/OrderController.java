package com.yu.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 *@descript 
 *@author yu
 *@date 2021/5/10 16:51
 *@version 1.0
 */
@RestController
public class OrderController {

    @Resource
    private RestTemplate restTemplate;
    private static final String PAYMENT_ZK_URL = "http://cloud-payment-service";

    @GetMapping(value = "/consumer/zk")
    public String orderZk(){
        return restTemplate.getForObject(PAYMENT_ZK_URL+"/payment/zk",String.class);
    }
}
