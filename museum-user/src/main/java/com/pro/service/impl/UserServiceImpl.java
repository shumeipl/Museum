package com.pro.service.impl;

import com.pro.pojo.User;
import com.pro.controller.mapper.UserMapper;
import com.pro.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xhw
 * @since 2022-11-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;


    /**
     * 登录
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        return userMapper.getUser(user);
    }

    /**
     * 根据id查询用户信息
     * @return
     */
    @Override
    public User getUserById(Integer userId) {
        return userMapper.getUserById(userId);
    }

    @Override
    public void uadateUser(User user) {
        userMapper.updateUser(user);
    }

    /**
     * 用户注册
     * @param user
     */
    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }
}
