package com.pro.controller.mapper;

import com.pro.pojo.Exhibits;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
public interface ExhibitsMapper extends BaseMapper<Exhibits> {

    /**
     * 获取所有展览
     * @return
     */
    List<Exhibits> getAllExhibits();

    /**
     * 根据状态获取展览
     * @param state
     * @return
     */
        List<Exhibits> getExhibitsByState(Integer state);

    /**
     * 根据状态分页获取展览
     * @param state
     * @param currentPage
     * @param pageSize
     * @return
     */
    List<Exhibits> getExhibitsByStatePage(@Param("state")Integer state,@Param("currentPage")Integer currentPage,@Param("pageSize")Integer pageSize);

    /**
     * 根据id获取展览
     * @param exhibitId
     * @return
     */
    Exhibits getExhibitById(Integer exhibitId);

    /**
     * 条件查询
     * @param
     * @return
     */
    List<Exhibits> getExhibitsByStateRange();


}
