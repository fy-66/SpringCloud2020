package com.yu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 *@descript 
 *@author yu
 *@date 2021/5/19 23:09
 *@version 1.0
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class StreamMqMain8801 {
    public static void main(String[] args) {
        SpringApplication.run(StreamMqMain8801.class,args);
    }
}
