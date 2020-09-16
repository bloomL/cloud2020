package com.learn.cloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @description: TODO
 * @author: lg
 * @create: 2020-09-12 10:38
 **/
@Service
public class PaymentService {

    public String paymentOk(Integer id){
        return "线程池： " + Thread.currentThread().getName() +" payment_OK,id: "+id;
    }

    /**
     *
     * 设置自身调用超时时间的峰值，eg:3000ms,峰值内可正常运行
     * 超过了须有兜底的处理方法，作服务降级fallback
     * @param id id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentTimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentTimeOut(Integer id){
        int time = 2;
        // int val = 10 / 0;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池： " + Thread.currentThread().getName()+" payment_TimeOut,id: "+id +" 耗时(秒)："+time;
    }

    public String paymentTimeOutHandler(Integer id){
        return "线程池： " + Thread.currentThread().getName()+" 系统繁忙或运行报错,id: "+id +" Sorry";
    }


    // ===服务熔断 ，属性名在HystrixCommandProperties中查询;官网

    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallBack",commandProperties = {
            @HystrixProperty(name = "circuitBreakerEnabled",value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreakerRequestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreakerSleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreakerErrorThresholdPercentage",value = "60"),//失败率多少后跳闸
    })
    public String paymentCircuitBreaker(Integer id){
        if (id < 0){
            throw new RuntimeException("id 不能为负数！");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功，流水号："+serialNumber;
    }

    public String paymentCircuitBreakerFallBack(Integer id){
        return "id 不能为负数，请重试！id： "+id;
    }
}
