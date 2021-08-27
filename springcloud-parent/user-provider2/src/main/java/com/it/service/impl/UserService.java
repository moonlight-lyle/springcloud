package com.it.service.impl;

import com.it.dao.UserDao;
import com.it.pojo.User;
import com.it.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ToDo
 *
 * @author Lyle
 * @date 2021/8/22
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
