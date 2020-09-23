package com.learn.cloud.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: TODO
 * @author: lg
 * @create: 2020-09-20 21:02
 **/
@RestController
@RequestMapping("/client-config")
@RefreshScope
public class ClientConfigController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping()
    public String getConfigInfo(){
        return  configInfo;
    }
}
