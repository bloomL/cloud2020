package com.learn.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @description: TODO
 * @author: lg
 * @create: 2020-09-21 21:27
 **/
@SpringBootApplication
@EnableEurekaClient
public class ClientConfigMain3366 {
    public static void main(String[] args) {
        SpringApplication.run(ClientConfigMain3366.class,args);
    }
}
