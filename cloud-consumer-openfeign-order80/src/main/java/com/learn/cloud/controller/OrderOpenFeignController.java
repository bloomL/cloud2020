package com.learn.cloud.controller;

import com.learn.cloud.entity.CommonResult;
import com.learn.cloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: TODO
 * @author: lg
 * @create: 2020-09-04 22:05
 **/
@RestController
@RequestMapping("/consumer")
public class OrderOpenFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/{id}")
    public CommonResult getById(@PathVariable("id") Long id){
        return paymentFeignService.getById(id);
    }
}
