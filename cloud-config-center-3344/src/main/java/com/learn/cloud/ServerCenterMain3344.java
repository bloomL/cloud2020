package com.learn.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @description: TODO
 * @author: lg
 * @create: 2020-09-16 23:27
 **/
@SpringBootApplication
@EnableConfigServer
public class ServerCenterMain3344 {
    public static void main(String[] args) {
        SpringApplication.run(ServerCenterMain3344.class,args);
    }
}
