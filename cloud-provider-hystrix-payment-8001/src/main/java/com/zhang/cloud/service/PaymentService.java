package com.zhang.cloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    public String paymentInfo_OK(Integer id) {
        return "线程池：  " + Thread.currentThread().getName() + "   paymentInfo_OK,  id:  " + id + "\t" + "O(∩_∩)O哈哈~";
    }

    //模拟拥堵的情况
    public String paymentInfo_Timeout(Integer id) {

        int timeNumber = 3;

        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "线程池：  " + Thread.currentThread().getName() + "   paymentInfo_Timeout,  id:  " + id
                + "\t" + "╭(╯^╰)╮" + "耗时" + timeNumber + "秒钟";
    }
}