package com.pro;

import com.pro.pojo.User;
import com.pro.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes = MuApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class MuApplicationTests {
    @Autowired
    //private UserMapper userMapper;
    private IUserService userService;

    @Test
    public void testGetUserById() {

        User userById = userService.getUserById(2);
        System.out.println(userById);
    }
}
