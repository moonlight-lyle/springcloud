package com.it.dao;

import com.it.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ToDo
 *
 * @author Lyle
 * @date 2021/8/22
 */
public interface UserDao extends JpaRepository<User,Integer> {
}
