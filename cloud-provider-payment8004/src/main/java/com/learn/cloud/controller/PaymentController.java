package com.learn.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @description: TODO
 * @author: lg
 * @create: 2020-08-30 14:20
 **/
@RestController
@RequestMapping("/pay")
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverport;

    @GetMapping
    public String getInfoWithZk(){
        return "springcloud with zookeeper: "+serverport+"\t"+ UUID.randomUUID().toString();
    }
}
