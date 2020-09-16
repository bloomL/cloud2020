package com.learn.cloud.service;

import com.learn.cloud.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @description: TODO
 * @author: lg
 * @create: 2020-09-04 22:14
 **/
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping(value = "/pay/{id}")
    CommonResult getById(@PathVariable("id") Long id);
}
