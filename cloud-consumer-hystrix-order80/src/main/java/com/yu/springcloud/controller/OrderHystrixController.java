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
 *@date 2021/5/11 22:59
 *@version 1.0
 */
@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "paymentGlobalFallbackMethod")
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping(value = "/consumer/hystrix/ok/{id}")
    String ok(@PathVariable("id") Long id){
        return paymentHystrixService.ok(id);
    }

    @GetMapping(value = "/consumer/hystrix/timeout/{id}")
    //@HystrixCommand(fallbackMethod = "paymentTimeoutFallbackMethod",commandProperties = {
    //    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    //})
    //@HystrixCommand //不定义时，默认类上的fallback方法
    String timeout(@PathVariable("id") Long id){
        return paymentHystrixService.timeout(id);
    }

    String paymentTimeoutFallbackMethod(Long id){
        return "兄弟放心，我特别老实，"+id+"放心交给我照顾。";
    }
    /**全局fallback处理*/
    public String paymentGlobalFallbackMethod(){
        return "Global，全局异常处理";
    }
}
