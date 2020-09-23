package com.learn.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: TODO
 * @author: lg
 * @create: 2020-09-21 21:28
 **/
@RestController
@RequestMapping("client-config")
@RefreshScope
public class ClientConfigController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${config.info}")
    private String configInfo;

    @GetMapping
    public String getClientConfigInfo(){
        return "serverPort： " + serverPort +"\t configInfo:  "+configInfo;
    }
}
