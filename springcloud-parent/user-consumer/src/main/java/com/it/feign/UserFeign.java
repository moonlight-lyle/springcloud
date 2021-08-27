package com.it.feign;

import com.it.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@FeignClient(name = "user-provider") // 指定要调用的微服务名称，即配置文件中的spring.application.name
public interface UserFeign {

    @GetMapping("/findByUser")
    User findByUser();


    /**
     * OpenFeign使用说明：
     * 1. 在消费端添加启动依赖
     *   <dependency>
     *             <groupId>org.springframework.cloud</groupId>
     *             <artifactId>spring-cloud-starter-openfeign</artifactId>
     *         </dependency>
     *  2. 写声明式的Feign接口，也就是这里的UserFeign，请求路径、参数即返回值和服务端接口保持一致即可，使用@FeignClient(name = "user-provider")标记调用哪个微服务
     *      注意springmvc相关注解也要拷贝过来
     *  3. 在启动类使用@EnableFeignClients启用Feign声明式的调用
     *  4. 在需要调用的地方@Autowired注入要调用的Feign
     *
     *  Feign默认支持了负载均衡
     *
     */
}
