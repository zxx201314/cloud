package com.zhang.cloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder) {
        //构建一个路由器
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        //路由器的id是：path_route_atguigu，规则是我现在访问/guonei，将会转发到http://news.baidu.com/guonei
        routes.route("path_route_baidu",
                r -> r.path("/baidu").uri("http://wwww.baidu.com")).build();
        return routes.build();
    }
}
