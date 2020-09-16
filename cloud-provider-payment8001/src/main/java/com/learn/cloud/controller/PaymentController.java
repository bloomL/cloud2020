package com.learn.cloud.controller;

import com.learn.cloud.entity.CommonResult;
import com.learn.cloud.entity.Payment;
import com.learn.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: TODO
 * @author: lg
 * @create: 2020-08-27 21:21
 **/
@RestController
@RequestMapping("/pay")
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverport;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private PaymentService paymentService;

    /**
     *
     * @param payment
     * @return
     */
    @PostMapping
    public CommonResult create(@RequestBody Payment payment){
        return paymentService.create(payment,serverport);
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public CommonResult getById(@PathVariable("id") Long id){
        return paymentService.getById(id,serverport);
    }

    @GetMapping("/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service: services) {
            log.info(service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance: instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

    /**
     * 负载轮询的服务
     * @return
     */
    @GetMapping("/lb")
    public String getPaymentLB(){
        return serverport;
    }
}
