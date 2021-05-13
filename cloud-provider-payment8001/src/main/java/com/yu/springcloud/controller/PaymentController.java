package com.yu.springcloud.controller;

import com.yu.springcloud.common.CommonResult;
import com.yu.springcloud.constants.CommonConstant;
import com.yu.springcloud.entities.Payment;
import com.yu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 *@descript PaymentController
 *@author yu
 *@date 2021/5/9 10:55
 *@version 1.0
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;
    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){

        int result = paymentService.create(payment);
        log.info("****插入结果：result=,{}",result);
        if (result>0){
            return CommonResult.success(result);
        }
        return CommonResult.failed(CommonConstant.SC_INTERNAL_SERVER_ERROR_500,"插入数据库失败！");
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment result = paymentService.getPaymentById(id);
        log.info("****查询结果：result={}，serverPort：{}",result,serverPort);
        if (result!=null){
            return CommonResult.universal(CommonConstant.SC_OK_200,"success,port:"+serverPort,result);
        }
        return CommonResult.failed(404,"没有该记录，ID为"+id);
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("***element:{}",service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance instance : instances) {
         log.info(instance.getServiceId()+"\t"+instance.getInstanceId()+"\t"+instance.getUri());
        }
        return discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }

}
