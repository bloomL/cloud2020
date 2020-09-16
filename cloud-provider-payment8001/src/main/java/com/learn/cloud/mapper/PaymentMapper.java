package com.learn.cloud.mapper;

import com.learn.cloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @description: TODO
 * @author: lg
 * @create: 2020-08-27 21:03
 **/
@Mapper
public interface PaymentMapper {

     int create(Payment payment);

     Payment getById(@Param("id") Long id);
}
