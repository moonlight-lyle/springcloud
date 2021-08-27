package com.it.controller;

import com.it.pojo.User;
import com.it.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ToDo
 *
 * @author Lyle
 * @date 2021/8/22
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/findAll")
    public List<User> findAll(){
//        System.out.println("调用实例222222222222222");
        return userService.findAll();
    }

    @GetMapping("/findByUser")
    public User findByUser(){
        System.out.println("调用实例222222222222222");
//        int i=1/0; // 模拟触发熔断机制
        // 模拟请求超时触发Hystrix
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return userService.findAll().get(0);
    }
}
