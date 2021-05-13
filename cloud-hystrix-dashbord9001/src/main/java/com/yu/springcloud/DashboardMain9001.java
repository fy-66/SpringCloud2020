package com.yu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 *@descript 
 *@author yu
 *@date 2021/5/12 21:40
 *@version 1.0
 */
@SpringBootApplication
@EnableHystrixDashboard
@EnableCircuitBreaker
public class DashboardMain9001 {

    public static void main(String[] args) {
        SpringApplication.run(DashboardMain9001.class,args);
    }
}
