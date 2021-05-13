package com.yu.springcloud.ib;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 *@descript 
 *@author yu
 *@date 2021/5/11 17:34
 *@version 1.0
 */
public interface LoadBalancer {

    ServiceInstance instance(List<ServiceInstance> instancesList);

    int getAndIncrement();
}
