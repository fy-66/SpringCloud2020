package com.yu.springcloud.config;

import org.springframework.web.client.RestTemplate;

/**
 *@descript 全局配置文件
 *@author yu
 *@date 2021/5/9 14:49
 *@version 1.0
 */
//@Configuration
public class ApplicationContextConfig {

    /**
     * @descript
     * @author yu
     * @date 2021/5/9
     * @return org.springframework.web.client.RestTemplate
     * @annotation LoadBalanced 赋予RestTemplate负载均衡的能力
     */
    //@Bean
    //@LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
