package com.learn.cloud.controller;

import com.learn.cloud.service.PaymentFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: TODO
 * @author: lg
 * @create: 2020-09-12 11:48
 **/
@RestController
@RequestMapping("/consumer")
@DefaultProperties(defaultFallback = "globalHandler")
public class OerderHystrixController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/ok/{id}")
    public String paymentOk(@PathVariable("id") Integer id){
        return paymentFeignService.paymentOk(id);
    }

    @GetMapping("/timeout/{id}")
    /**
     * 单独服务兜底
     * @HystrixCommand(fallbackMethod = "paymentTimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })*/
    @HystrixCommand
    public String paymentTimeOut(@PathVariable("id") Integer id){
        //int val = 10 / 0 ;
        return paymentFeignService.paymentTimeOut(id);
    }


    public String paymentTimeOutHandler(@PathVariable("id") Integer id){
        return "我是消费者8000，对方支付系统繁忙请10s再试或自己运行出错，id： "+id;
    }


    public String globalHandler(){
        return "全局服务降级兜底";
    }
}
