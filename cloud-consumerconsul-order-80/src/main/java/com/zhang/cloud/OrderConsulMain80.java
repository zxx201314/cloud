package com.zhang.cloud;

import com.zhang.cloud.com.zhang.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Auther: zhangxx
 * @Date: 2022/7/17 20:16
 * @Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name = "consul-provider-payment",configuration = MySelfRule.class)
public class OrderConsulMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsulMain80.class,args);
    }
}
