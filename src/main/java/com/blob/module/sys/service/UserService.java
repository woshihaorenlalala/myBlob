package com.blob.module.sys.service;

import com.blob.module.sys.dao.UserDao;
import com.blob.module.sys.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cc on 2018/10/8.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 通过用户名查询用户
     * @param username
     * @return User
     */
    public User findByUsername(String username){
        return userDao.findByUsername(username);
    }
}
