package com.zhang.cloud.controller;

import com.zhang.cloud.common.CommonResult;
import com.zhang.cloud.entities.Payment;
import com.zhang.cloud.loadbalance.MyLoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@Slf4j
public class OrderController {
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private MyLoadBalancer myLoadBalancer;

    //暂时在这里写死
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    //按理说插入数据应该是POST，可以从浏览器只能发GET请求，尽管不符合RESTFUL，
    // 但是下面的template.postForObject调用却是POST请求
    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        //调用生产者模块中的生产方法
        return restTemplate.postForObject(PAYMENT_URL + "payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    /**
     * 测试我们自己的轮询算法
     *
     * @return
     */
    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLoadBalancer() {

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        if (instances == null || instances.size() <= 0) {
            return null;
        }
        ServiceInstance serviceInstance = myLoadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();

        return restTemplate.getForObject(uri + "/payment/lb", String.class);
    }
}
