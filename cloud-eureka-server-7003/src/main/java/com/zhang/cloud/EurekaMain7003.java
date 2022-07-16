package com.zhang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Auther: zhangxx
 * @Date: 2022/7/16 21:38
 * @Description:
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaMain7003 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7003.class, args);
    }
}
