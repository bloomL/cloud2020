package com.learn.cloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: TODO
 * @author: lg
 * @create: 2020-09-15 21:56
 **/
@Configuration
public class GateWayConfig {

    /**
     * 配置一个ID为customize_route的路由规则
     * 当访问地址为http://localhost:9527/guonei时会自动转发到地址http://news.baidu.com/guonei
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator customizeRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("customize_route",
                f -> f.path("/guonei")
                        .uri("http://news.baidu.com/guonei"))
                .build();
        return routes.build();
    }

    @Bean
    public RouteLocator customizeRouteLocator2(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("customize_route2",
                f -> f.path("/guoji")
                        .uri("http://news.baidu.com/guoji"))
                .build();
        return routes.build();
    }

}
