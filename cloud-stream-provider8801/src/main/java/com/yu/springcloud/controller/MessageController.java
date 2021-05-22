package com.yu.springcloud.controller;

import com.yu.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *@descript 
 *@author yu
 *@date 2021/5/19 23:28
 *@version 1.0
 */
@RestController
public class MessageController {

    @Resource
    private IMessageProvider provider;

    @GetMapping(value = "send")
    public String send(){
        return provider.send();
    }
}
