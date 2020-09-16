package com.learn.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @description: 启动类
 * @author: lg
 * @create: 2020-08-26 22:18
 **/
@SpringBootApplication
@EnableEurekaClient
//服务发现
@EnableDiscoveryClient
public class PaymentMain8001 {

    /**
     * @Description TODO
     * @Param [args]
     * @return void
     **/
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class,args);
    }

}
