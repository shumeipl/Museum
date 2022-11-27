package com.pro.service.impl;

import com.pro.pojo.Booking;
import com.pro.controller.mapper.BookingMapper;
import com.pro.service.IBookingService;
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
 * @since 2022-11-26
 */
@Service
public class BookingServiceImpl extends ServiceImpl<BookingMapper, Booking> implements IBookingService {

    @Autowired
    private BookingMapper bookingMapper;

    /**
     * 添加预约
     * @param booking
     */
    @Override
    public void addBooking(Booking booking) {
        bookingMapper.addBooking(booking);
    }

    /**
     * 根据用户id查询所有
     * @param userId
     * @return
     */
    @Override
    public List<Booking> getAllById(Integer userId) {
        return bookingMapper.getAllById(userId);
    }

    /**
     * 根据用户id分页查询
     * @param userId
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public List<Booking> getBookingByIdPage(Integer userId, Integer currentPage, Integer pageSize) {
        return bookingMapper.getBookingByIdPage(userId,currentPage,pageSize);
    }

}
