package com.learn.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @description: TODO
 * @author: lg
 * @create: 2020-09-01 21:49
 **/
@RestController
@RequestMapping("/pay")
public class PaymentController {

    @Value("${server.port}")
    private String serverport;

    @GetMapping
    public String getInfoWithConsul(){
        return "springcloud with consul: "+serverport+"\t"+ UUID.randomUUID().toString();
    }
}
