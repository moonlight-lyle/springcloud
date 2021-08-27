package com.it.controller;

import com.it.feign.UserFeign;
import com.it.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign")
public class TestUserFeignController {

    @Autowired
    private UserFeign userFeign;

    @RequestMapping("/test")
    public User findByUser(){
        User byUser = userFeign.findByUser();
        System.out.println(byUser.getUsername()+":"+byUser.getAge());
        return byUser;
    }
}
