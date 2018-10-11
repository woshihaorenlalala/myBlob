package com.blob.module.module.sys.dao;

import com.blob.module.module.sys.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by cc on 2018/9/27.
 */
@Repository
public interface UserDao extends JpaRepository<User, Integer>{

    User findByUsername(String username);
}
