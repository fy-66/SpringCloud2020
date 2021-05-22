package com.yu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *@descript 
 *@author yu
 *@date 2021/5/19 11:45
 *@version 1.0
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient
public class ConfigClientMai3366 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMai3366.class,args);
    }
}
