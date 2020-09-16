package com.learn.cloud.controller;

import com.learn.cloud.entity.CommonResult;
import com.learn.cloud.entity.Payment;
import com.learn.cloud.lb.MyLB;
import com.learn.cloud.lb.MyloadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @description: TODO
 * @author: lg
 * @create: 2020-08-27 22:33
 **/
@RestController
@RequestMapping(value = "/consumer")
public class OrderController {

    //public static final String URL = "http://localhost:8001";
    public static final String URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private MyloadBalancer myloadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/pay")
    public CommonResult create(Payment payment){
        return restTemplate.postForObject(URL+"/pay",payment,CommonResult.class);
    }

    @GetMapping(value = "/pay/{id}")
    public CommonResult getById(@PathVariable("id") Long id){
        return restTemplate.getForObject(URL+"/pay/"+id,CommonResult.class);
    }

    @GetMapping
    public CommonResult entityCreate(Payment payment){
        ResponseEntity<CommonResult> entity = restTemplate.postForEntity(URL+"/pay",payment,CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else {
            return new CommonResult(444,"操作失败");
        }
    }

    @GetMapping(value = "/{id}")
    public CommonResult getEntityById(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(URL + "/pay/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else {
            return new CommonResult(444,"操作失败");
        }
    }

    @GetMapping("/lb")
    public String getMyLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0 ){
            return null;
        }
        ServiceInstance instance = myloadBalancer.instance(instances);
        URI uri = instance.getUri();
        return restTemplate.getForObject(uri + "/pay/lb", String.class);

    }

}
