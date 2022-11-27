package com.pro.controller.mapper;

import com.pro.pojo.Type;
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
 * @since 2022-11-25
 */
@Mapper
@Repository
public interface TypeMapper extends BaseMapper<Type> {

    /**
     * 查询所有藏品类型
     * @return
     */
    List<Type> getAllType();
}
