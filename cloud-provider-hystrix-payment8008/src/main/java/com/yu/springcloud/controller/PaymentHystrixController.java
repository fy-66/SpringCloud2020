package com.yu.springcloud.controller;

import com.yu.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *@descript 
 *@author yu
 *@date 2021/5/11 22:09
 *@version 1.0
 */
@RestController
@Slf4j
public class PaymentHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String ok(@PathVariable("id") Long id){
        return paymentHystrixService.ok(id);
    }

    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    public String timeout(@PathVariable("id") Long id){
        return paymentHystrixService.timeout(id);
    }
}
