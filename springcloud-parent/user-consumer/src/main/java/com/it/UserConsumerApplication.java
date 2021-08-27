package com.it;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * ToDo
 *
 * @author Lyle
 * @date 2021/8/22
 */
@SpringBootApplication
@EnableEurekaClient // 开启Eureka客户端
@EnableCircuitBreaker // 开启熔断保护机制
@EnableFeignClients // 启用Feign声明式的调用
public class UserConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserConsumerApplication.class,args);
    }

    @Bean
    @LoadBalanced // 开启负载均衡，ribbon集成了RestTemplate实现负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
