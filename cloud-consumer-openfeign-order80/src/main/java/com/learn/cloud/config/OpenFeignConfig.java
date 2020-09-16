package com.learn.cloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 定义OpenFeign日志级别
 * @author: lg
 * @create: 2020-09-04 22:45
 **/
@Configuration
public class OpenFeignConfig {

    @Bean
    Logger.Level getOpenFeignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
