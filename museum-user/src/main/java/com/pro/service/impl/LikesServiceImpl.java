package com.pro.service.impl;

import com.pro.pojo.Likes;
import com.pro.controller.mapper.LikesMapper;
import com.pro.service.ILikesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xhw
 * @since 2022-11-22
 */
@Service
public class LikesServiceImpl extends ServiceImpl<LikesMapper, Likes> implements ILikesService {

    @Autowired
    private LikesMapper likesMapper;

    /**
     * 根据id查找收藏
     * @param userId
     * @return
     */
    @Override
    public List<Likes> getAllLikesById(Integer userId) {
        return likesMapper.getAllLikesById(userId);
    }
}
