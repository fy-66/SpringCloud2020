package com.yu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *@descript 
 *@author yu
 *@date 2021/5/12 23:32
 *@version 1.0
 */
@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();
        //http://news.baidu.com/guonei
        routes.route("path_route",
                r -> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei"));
        routes.route("path_route2",
                r -> r.path("/guoji")
                        .uri("http://news.baidu.com/guoji"));

        return routes.build();
    }
}
