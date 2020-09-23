package com.learn.cloud.controller;

import com.learn.cloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: TODO
 * @author: lg
 * @create: 2020-09-23 22:17
 **/
@RestController
@RequestMapping("/message-provider")
public class MessageProviderController {
    @Resource
    private IMessageProvider messageProvider;

    @GetMapping
    public String sendMessage(){
        return messageProvider.send();
    }

}
