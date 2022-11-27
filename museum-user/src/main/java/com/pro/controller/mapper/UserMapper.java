package com.pro.controller.mapper;

import com.pro.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xhw
 * @since 2022-11-22
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

    /**
     * 查询用户
     * @param user
     * @return
     */
    User getUser(User user);

    /**
     * 根据用户id查询用户信息
     * @param userId
     * @return
     */
    User getUserById(Integer userId);


    /**
     * 用户修改信息
     * @param user
     */
    void updateUser(User user);

    /**
     * 用户注册（添加用户）
     * @param user
     */
    void addUser(User user);


}
