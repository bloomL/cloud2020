package com.learn.cloud.service.impl;

import com.learn.cloud.service.PaymentFeignService;
import org.springframework.stereotype.Component;

/**
 * @description: TODO
 * @author: lg
 * @create: 2020-09-14 21:55
 **/
@Component
public class PaymentFeignFallBackService implements PaymentFeignService {
    @Override
    public String paymentOk(Integer id) {
        return "支付方已宕机，请稍后再试，Sorry";
    }

    @Override
    public String paymentTimeOut(Integer id) {
        return "fallBack paymentTimeOut Sorry!";
    }
}
