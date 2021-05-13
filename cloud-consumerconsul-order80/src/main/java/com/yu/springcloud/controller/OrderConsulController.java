package com.yu.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 *@descript 
 *@author yu
 *@date 2021/5/10 20:07
 *@version 1.0
 */
@RestController
public class OrderConsulController {

    @Resource
    private RestTemplate restTemplate;

    private static final String INVOKE_URL = "http://consul-provider-payment";

    @GetMapping(value = "/consumer/consul")
    public String paymentInfo(){
        return restTemplate.getForObject(INVOKE_URL+"/payment/consul",String.class);
    }
}
