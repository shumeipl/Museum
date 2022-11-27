package com.pro.controller.mapper;

import com.pro.pojo.Booking;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xhw
 * @since 2022-11-26
 */
@Mapper
@Repository
public interface BookingMapper extends BaseMapper<Booking> {

    /**
     * 添加预约
     * @param booking
     */
    void addBooking(Booking booking);

    /**
     * 根据用户id查询所有预约
     * @param userId
     * @return
     */
    List<Booking> getAllById(Integer userId);

    /**
     * 根据用户id分页查询
     * @param userId
     * @param currentPage
     * @param pageSize
     * @return
     */
    List<Booking> getBookingByIdPage(@Param("userId")Integer userId, @Param("currentPage")Integer currentPage, @Param("pageSize")Integer pageSize);
}
