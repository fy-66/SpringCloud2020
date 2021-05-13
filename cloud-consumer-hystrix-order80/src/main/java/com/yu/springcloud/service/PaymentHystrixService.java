package com.yu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *@descript 通过feign调用支付服务
 *  降级方法，   ----前提----：yml中，开启降级方法feign.hystrix.enabled = true
 *    一：controller 定义单个，加
 *      @HystrixCommand(fallbackMethod = "paymentTimeoutFallbackMethod",commandProperties = {
 *         @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
 *     })
 *     二：controller 定义默认方法
 *          类上 @DefaultProperties(defaultFallback = "paymentGlobalFallbackMethod")
 *          方法上 @HystrixCommand，不定义具体降级方法时，采用类上的默认方法
 *     三：在feignClient端为每个方法都定义降级方法
 *          在@FeignClient(value = "CONSUL-PROVIDER-HYSTRIX-PAYMENT")上加fallback=clazz.class
 *          clazz实现client接口
 *@author yu
 *@date 2021/5/11 22:57
 *@version 1.0
 */
@Component
@FeignClient(value = "CONSUL-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentHystrixServiceFallback.class)
public interface PaymentHystrixService {

    @GetMapping(value = "/payment/hystrix/ok/{id}")
    String ok(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    String timeout(@PathVariable("id") Long id);
}
