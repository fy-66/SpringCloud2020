package com.yu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 *@descript 
 *@author yu
 *@date 2021/5/12 18:45
 *@version 1.0
 */
@Component
public class PaymentHystrixServiceFallback implements PaymentHystrixService {

    @Override
    public String ok(Long id) {
        return "consumer ok fallback method,id: "+id;
    }

    @Override
    public String timeout(Long id) {
        return "consumer timeout fallback method,id: "+id;
    }
}
