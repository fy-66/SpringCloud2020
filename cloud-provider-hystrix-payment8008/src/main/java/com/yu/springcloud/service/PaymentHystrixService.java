package com.yu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 *@descript
 *@author yu
 *@date 2021/5/11 22:03
 *@version 1.0
 */
@Service
public class PaymentHystrixService {

    public String ok(Long id){
        return "线程："+Thread.currentThread().getName()+"id: "+id+", success";
    }

    @HystrixCommand(fallbackMethod = "timeoutHystrixHeader",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })
    public String timeout(Long id){
        //当程序出现异常时，依然会运行到兜底方案
        //int age = 10/0;
        int  sleepTime = 2;
        try {
            TimeUnit.SECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "线程："+Thread.currentThread().getName()+"id: "+id+", sleep (second): "+sleepTime;
    }

    public String timeoutHystrixHeader(Long id){
        return "线程："+Thread.currentThread().getName()+"id: "+id+", 启动超级备胎计划";
    }

}
