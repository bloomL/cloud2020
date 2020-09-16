package com.learn.cloud.service.impl;

import com.learn.cloud.entity.CommonResult;
import com.learn.cloud.entity.Payment;
import com.learn.cloud.mapper.PaymentMapper;
import com.learn.cloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description: TODO
 * @author: lg
 * @create: 2020-08-27 21:19
 **/
@Service
public class PaymentServiceImpl implements PaymentService {
    //@Autowired

    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public CommonResult create(Payment payment, String serverport) {
        int result = paymentMapper.create(payment);
        CommonResult commonResult = result > 0 ? new CommonResult(200, "保存数据成功,serverport："+serverport, result) : new CommonResult(400, "保存数据失败", null);
        return commonResult;
    }

    @Override
    public CommonResult getById(Long id, String serverport) {
        Payment payment = paymentMapper.getById(id);
        CommonResult commonResult = payment != null ? new CommonResult(200, "查询成功,serverport "+serverport, payment) : new CommonResult(400, "未查询到相关记录", null);
        return commonResult;
    }
}
