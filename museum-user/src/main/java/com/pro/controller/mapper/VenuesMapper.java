package com.pro.controller.mapper;

import com.pro.pojo.Venues;
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
public interface VenuesMapper extends BaseMapper<Venues> {

    /**
     * 查询所有馆
     * @return
     */
    List<Venues> getAllVenues();

    /**
     * 根据馆名查询
     * @param venueName
     * @return
     */
    Venues getVenueByName(String venueName);

    /**
     * 根据id查询
     * @param venueId
     * @return
     */
    Venues getVenueById(Integer venueId);

}
