package com.pro.service;

import com.pro.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xhw
 * @since 2022-11-22
 */
@Service
public interface IUserService extends IService<User> {

    /**
     * 登录
     * @param user
     * @return
     */
    User login(User user);
    /**
     * 根据id查询用户信息
     * @return
     */
    User getUserById(Integer userId);

    /**
     * 用户修改信息
     * @param user
     */
    void uadateUser(User user);

    /**
     * 用户注册
     * @param user
     */
    void addUser(User user);

}
