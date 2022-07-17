package com.zhang.cloud.com.zhang.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: zhangxx
 * @Date: 2022/7/17 21:09
 * @Description:
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule iRule(){
        return new RandomRule();
    }
}
