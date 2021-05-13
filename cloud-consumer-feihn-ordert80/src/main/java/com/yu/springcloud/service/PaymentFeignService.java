package com.yu.springcloud.service;

import com.yu.springcloud.common.CommonResult;
import com.yu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *@descript 
 *@author yu
 *@date 2021/5/11 19:56
 *@version 1.0
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")
    CommonResult<Payment> getPayment(@PathVariable("id") Long id);

}
