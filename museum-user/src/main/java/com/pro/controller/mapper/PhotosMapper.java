package com.pro.controller.mapper;

import com.pro.pojo.Photos;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xhw
 * @since 2022-11-23
 */
@Mapper
@Repository
public interface PhotosMapper extends BaseMapper<Photos> {

    /**
     * 查询轮播图
     * @return
     */
    List<Photos> getPhotos();
}
