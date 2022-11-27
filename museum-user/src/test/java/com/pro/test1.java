package com.pro;

import com.pro.controller.mapper.UserMapper;
import com.pro.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = MuApplication.class)
public class test1 {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testGetUserById(){
        User userById = userMapper.getUserById(2);
        System.out.println(userById);
    }
}
