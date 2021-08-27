package com.it.controller;

import com.it.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
@DefaultProperties(defaultFallback = "myDefaultFallBack") // 使用该注解，可以使该类中所有方法出现错误后，调用方法myDefaultFallBack返回备用数据
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/look/{username}")
//    @HystrixCommand(fallbackMethod = "myFallBackMethod") // 注解修饰该方法标识该方法被保护，当出现错误的时候调用该方法myFallBackMethod
    @HystrixCommand // 使用全局性的默认方法，即类上注释的@DefaultProperties方法
    public String look(@PathVariable(name = "username") String username) {
        // 模拟调用其他微服务
//        User user = restTemplate.getForObject("http://localhost:18081/user/findByUser", User.class);
        // 动态获取ip和端口
        List<ServiceInstance> instances = discoveryClient.getInstances("USER-PROVIDER");
        ServiceInstance serviceInstance = instances.get(0);
        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();
//        User user = restTemplate.getForObject("http://" + host + ":" + port + "/user/findByUser", User.class);
        // 负载均衡方式调用
        // 这种写法比较low，硬编码写死了，可以采用OpenFeign实现声明式的调用，使代码更加优雅
        User user = restTemplate.getForObject("http://USER-PROVIDER/user/findByUser", User.class);
        System.out.println(user.getId() + ":" + user.getUsername());
        return "success";
    }

    /**
     * 出现错误后，熔断保护机制触发的执行方法
     *  注意参数要与上面的方法保持一致
     * @return
     */
    public String myFallBackMethod(String username){
        return "出现错误后，返回备用数据";
    }

    /**
     *  该方法用于出现错误后，返回备胎数据
     *  注意该方法不要使用任何参数
     * @return
     */
    public String myDefaultFallBack(){
        return "全局性质，所有方法都可以使用该方法返回备用数据！";
    }
}
