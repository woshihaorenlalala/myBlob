package com.blob;

import com.blob.module.sys.dao.UserDao;
import com.blob.module.sys.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlobApplicationTests {

	@Autowired
	private UserDao userDao;

	@Test
	public void contextLoads() {
		List<User> list = userDao.findAll();
	}

}
