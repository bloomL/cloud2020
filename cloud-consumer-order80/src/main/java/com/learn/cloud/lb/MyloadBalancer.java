package com.learn.cloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @description: 自定义负载均衡
 * @author: lg
 * @create: 2020-09-03 23:20
 **/
public interface MyloadBalancer {

    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
