package com.pro.controller.mapper;

import com.pro.pojo.Likes;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

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
public interface LikesMapper extends BaseMapper<Likes> {

    /**
     * 根据id查找收藏
     * @param userId
     * @return
     */
    List<Likes> getAllLikesById(Integer userId);

}
