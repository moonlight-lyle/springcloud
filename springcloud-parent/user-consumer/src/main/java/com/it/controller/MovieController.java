package com.it.controller;

import com.it.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * ToDo
 *
 * @author Lyle
 * @date 2021/8/22
 */
@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/look/{username}")
    public String look(@PathVariable(name = "username") String username) {
        // 模拟调用其他微服务
//        User user = restTemplate.getForObject("http://localhost:18081/user/findByUser", User.class);
        // 动态获取ip和端口
        List<ServiceInstance> instances = discoveryClient.getInstances("USER-PROVIDER");
        ServiceInstance serviceInstance = instances.get(0);
        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();
        User user = restTemplate.getForObject("http://" + host + ":" + port + "/user/findByUser", User.class);
        System.out.println(user.getId() + ":" + user.getUsername());
        return "success";
    }
}
