package com.pro.controller.mapper;

import com.pro.pojo.Collections;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.net.CookieHandler;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xhw
 * @since 2022-11-25
 */
@Mapper
@Repository
public interface CollectionsMapper extends BaseMapper<Collections> {

    /**
     * 根据类型查询藏品
     * @param type
     * @return
     */
    List<Collections> getByType(String type);

    /**
     * 根据类型分页查询
     * @param type
     * @param currentPage
     * @param pageSize
     * @return
     */
    List<Collections> getByTypePage(@Param("type")String type, @Param("currentPage")Integer currentPage, @Param("pageSize")Integer pageSize);

    /**
     * 根据id查询藏品
     * @param collectionId
     * @return
     */
    Collections getCollectionById(Integer collectionId);

}
