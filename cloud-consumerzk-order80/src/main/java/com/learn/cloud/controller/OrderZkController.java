package com.learn.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @description: TODO
 * @author: lg
 * @create: 2020-08-30 15:02
 **/
@RestController
@RequestMapping("/consumer")
public class OrderZkController {

    private static final String URL = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping
    public String getProviderInfo(){
        return restTemplate.getForObject(URL + "/pay", String.class);
    }
}
