package com.learn.cloud.service;

import com.learn.cloud.entity.CommonResult;
import com.learn.cloud.entity.Payment;

/**
 * @description: TODO
 * @author: lg
 * @create: 2020-08-27 21:18
 **/
public interface PaymentService {

    CommonResult create(Payment payment, String serverport);

    CommonResult getById(Long id, String serverport);
}
