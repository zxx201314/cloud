package com.zhang.cloud.loadbalance;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: zhangxx
 * @Date: 2022/7/17 22:04
 * @Description:
 */
@Component
@Slf4j
public class MyLoadBalancer implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current = this.atomicInteger.get();
        int next;
        do {
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;

        }
        while (this.atomicInteger.compareAndSet(current, next));
        log.info(">>>>>>>>>>>>>>>>第几次访问的次数：next" + next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();

        return serviceInstances.get(index);
    }


}
