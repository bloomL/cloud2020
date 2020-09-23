package com.learn.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @description: TODO
 * @author: lg
 * @create: 2020-09-20 20:52
 **/
@SpringBootApplication
@EnableEurekaClient
public class ClientConfigMain3355 {
    public static void main(String[] args) {
        SpringApplication.run(ClientConfigMain3355.class,args);
    }
}
