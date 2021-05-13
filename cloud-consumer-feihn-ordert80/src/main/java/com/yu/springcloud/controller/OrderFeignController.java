package com.yu.springcloud.controller;

import com.yu.springcloud.common.CommonResult;
import com.yu.springcloud.entities.Payment;
import com.yu.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *@descript 
 *@author yu
 *@date 2021/5/11 19:59
 *@version 1.0
 */
@RestController
@Slf4j
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        log.info("请求服务，id：{}",id);
        return paymentFeignService.getPayment(id);
    }
}
