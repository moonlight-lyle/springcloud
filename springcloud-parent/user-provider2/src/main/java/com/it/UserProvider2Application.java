package com.it;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * ToDo
 *
 * @author Lyle
 * @date 2021/8/22
 */
@SpringBootApplication
@EnableEurekaClient
public class UserProvider2Application {
    public static void main(String[] args) {
        SpringApplication.run(UserProvider2Application.class,args);
    }
}
