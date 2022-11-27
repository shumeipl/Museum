package com.pro.service;

import com.pro.pojo.Likes;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xhw
 * @since 2022-11-22
 */
@Service
public interface ILikesService extends IService<Likes> {

    /**
     * 根据id查找收藏
     * @param userId
     * @return
     */
    List<Likes> getAllLikesById(Integer userId);
}
