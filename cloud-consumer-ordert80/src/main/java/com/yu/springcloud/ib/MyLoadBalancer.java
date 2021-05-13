package com.yu.springcloud.ib;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *@descript 
 *@author yu
 *@date 2021/5/11 17:38
 *@version 1.0
 */
@Component
public class MyLoadBalancer implements LoadBalancer {

    private AtomicInteger atomicInteger =
            new AtomicInteger(0);

    @Override
    public ServiceInstance instance(List<ServiceInstance> instancesList) {
        int size;
        if (instancesList==null || (size=instancesList.size()) < 1){
            return null;
        }

        return instancesList.get(getAndIncrement() % size);
    }

    @Override
    public final int getAndIncrement(){
        int current,next;
        //自旋锁
        do {
            current = atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current+1;
        } while (!atomicInteger.compareAndSet(current,next));

        return next;
    }
}
