package com.zhang.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zhang.cloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
//没有配置过fallback，就找在该类上配置的defaultfallback，配置过的就找自己单独配置的。
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod") // 注解对paymentInfo_OK不生效，因为paymentInfo_OK方法上没有添加@HystrixCommand注解
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {

        String result = paymentHystrixService.paymentInfo_OK(id);

        return result;
    }
    /**
     * HystrixCommand 规定这个线程的超时时间是3s，3s后就由fallbackMethod指定的方法帮我“兜底”（服务降级）
     * @param id
     * @return
     */
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",
//                    value = "3000")})
    @HystrixCommand
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id") Integer id) {
//        int i = 10/0; //模拟程序异常报错，看是否会降级兜底
        String result = paymentHystrixService.paymentInfo_Timeout(id);

        return result;
    }
    public String paymentInfo_TimeoutHandler(Integer id){
        return "线程池：  "+ Thread.currentThread().getName()+"   paymentInfo_TimeoutHandler,  id:  "+id
                +"\t"+"o(╥﹏╥)o";
    }
    public String payment_Global_FallbackMethod(){
        return "Global Fallback 对方服务忙或者服务已宕机";
    }

}
