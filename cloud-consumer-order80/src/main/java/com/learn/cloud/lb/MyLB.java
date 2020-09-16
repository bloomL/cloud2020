package com.learn.cloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: 自定义轮询算法实现
 * @author: lg
 * @create: 2020-09-03 23:24
 **/
@Component
public class MyLB implements MyloadBalancer{

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;
        int next;
        //自旋锁 + CAS
        do {
            current = this.atomicInteger.get();
            next = current + 1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("*******第"+next+"次访问************");
        return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
