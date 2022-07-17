package com.zhang.cloud.loadbalance;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Auther: zhangxx
 * @Date: 2022/7/17 22:04
 * @Description:
 */
public interface LoadBalancer {
    //instances()方法：从List<ServiceInstance>得到一个ServiceInstance微服务实例对象
    ServiceInstance instances(List<ServiceInstance> serviceInstances);

}
