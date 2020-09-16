package com.learn.cloud.service;

import com.learn.cloud.service.impl.PaymentFeignFallBackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @description: TODO
 * @author: lg
 * @create: 2020-09-12 11:46
 **/
@Component
@FeignClient(value = "CLOUD-HYSTRIX-PAYMENT-SERVICE",fallback = PaymentFeignFallBackService.class)
public interface PaymentFeignService {
    @GetMapping("/pay/ok/{id}")
     String paymentOk(@PathVariable("id") Integer id);

    @GetMapping("/pay/timeout/{id}")
     String paymentTimeOut(@PathVariable("id") Integer id);
}
