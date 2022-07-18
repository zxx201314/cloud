package com.zhang.cloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: zhangxx
 * @Date: 2022/7/18 19:55
 * @Description:
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLogLevel() {
        return Logger.Level.FULL;
    }
}
