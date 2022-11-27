package com.pro.service;

import com.pro.pojo.Booking;
import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xhw
 * @since 2022-11-26
 */
@Service
public interface IBookingService extends IService<Booking> {

    /**
     * 添加预约
     * @param booking
     */
    void addBooking(Booking booking);

    /**
     * 根据用户Id查询所有
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
    List<Booking> getBookingByIdPage(Integer userId,Integer currentPage,Integer pageSize);

}
