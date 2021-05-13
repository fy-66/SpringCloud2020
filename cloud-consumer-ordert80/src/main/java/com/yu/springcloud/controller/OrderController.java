package com.yu.springcloud.controller;

import com.yu.springcloud.common.CommonResult;
import com.yu.springcloud.entities.Payment;
import com.yu.springcloud.ib.MyLoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 *@descript 
 *@author yu
 *@date 2021/5/9 14:45
 *@version 1.0
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private RestTemplate restTemplate;
    //private static final String PAYMENT_URL = "http://localhost:8001/";
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE/";
    /**
     * 自实现负载算法
     */
    @Resource
    private MyLoadBalancer myLoadBalancer;
    @Resource
    private DiscoveryClient discoveryClient;


    @GetMapping(value = "/consumer/create")
    public CommonResult create(Payment payment){

        return restTemplate.postForObject(PAYMENT_URL+"payment/create",payment,CommonResult.class);
    }

    @GetMapping(value = "/consumer/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"payment/get/"+id,CommonResult.class);
    }

    /**
     * 测试restTemplate.getForEntity()
     * @param id 数据id
     * @return
     */
    @GetMapping(value = "/consumer/entity/{id}")
    public CommonResult getForEntity(@PathVariable("id") Long id){

        ResponseEntity<CommonResult> entity =
                restTemplate.getForEntity(PAYMENT_URL + "payment/get/" + id, CommonResult.class);

        //只是为了测试getForEntity的信息，不经有数据，还有请求的响应信息
        if (entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }

        return CommonResult.failed(404,"failed");
    }


    /**
     * 模拟实现负载算法实现
     *      需要将restTemplate的轮询算法注释掉
     * @author yu
     * @date 2021/5/11
     * @return java.lang.String
     */
    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        ServiceInstance serviceInstance = myLoadBalancer.instance(instances);
        if (serviceInstance==null){
            return null;
        }
        String uri = serviceInstance.getUri()+"/payment/lb";
        log.info("uri: {}",uri);
        return "servicePort: "+restTemplate.getForObject(uri,String.class);
    }

}
