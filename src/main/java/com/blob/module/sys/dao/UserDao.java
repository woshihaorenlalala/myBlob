package com.blob.module.sys.dao;

import com.blob.module.sys.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by cc on 2018/9/27.
 */
public interface UserDao extends JpaRepository<User, Integer>{

    User findByUsername(String username);
}
