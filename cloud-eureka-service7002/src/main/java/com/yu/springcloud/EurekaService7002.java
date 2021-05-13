package com.yu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 *@descript eureka 7002
 *@author yu
 *@date 2021/5/9 16:09
 *@version 1.0
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaServer
public class EurekaService7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaService7002.class,args);
    }
}
