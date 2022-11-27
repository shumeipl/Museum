package com.pro.controller;


import com.pro.pojo.Booking;
import com.pro.pojo.Exhibits;
import com.pro.service.IBookingService;
import com.pro.service.IExhibitsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xhw
 * @since 2022-11-26
 */
@Controller
@RequestMapping("booking")
public class BookingController {
    @Autowired
    private IBookingService bookingService;
    @Autowired
    private IExhibitsService exhibitsService;


    @ApiOperation(value = "预约")
    @RequestMapping(value = "addBooking",method = RequestMethod.POST)
    public String addBooking(@RequestParam(value = "exhibitId",required = false)Integer exhibitId,
                             @RequestParam(value = "exhibitTitle",required = false)String exhibitTitle,
                             @RequestParam(value = "bookingTime",required = false)String bookingTime,
                             @RequestParam(value = "userId",required = false)Integer userId,
                             @RequestParam(value = "venueName",required = false)String venueName,
                             @RequestParam(value = "workerId",required = false) Integer workerId,
                             ModelMap modelMap){
        Booking booking = new Booking();
        booking.setExhibitId(exhibitId);
        booking.setExhibitTitle(exhibitTitle);
        booking.setBookingTime(bookingTime);
        booking.setUserId(userId);
        booking.setVenueName(venueName);
        booking.setWorkerId(workerId);
        bookingService.addBooking(booking);
        List<Exhibits> exhibitList = exhibitsService.getExhibitsByStateRange();
        modelMap.addAttribute("exhibitList",exhibitList);
        return "exhibitBooking";
    }

    @ApiOperation(value = "根据用户id分页查询")
    @RequestMapping("getBookingByIdPage")
    public String getBookingByIdPage(Integer userId,Integer currentPage,Integer pageSize,ModelMap modelMap){
        List<Booking> allBookings = bookingService.getAllById(userId);
        if (currentPage == null){
            currentPage = 1;
        }
        if (pageSize == null){
            pageSize = 12;
        }
        int totalPages = 0;
        if (allBookings.size() % pageSize == 0){
            totalPages = allBookings.size() /pageSize;
        }else{
            totalPages  = (allBookings.size()/pageSize)+ 1;
        }
        List<Booking> bookings = bookingService.getBookingByIdPage(userId, (currentPage-1)*pageSize, pageSize);
        modelMap.addAttribute("bookings",bookings);
        modelMap.addAttribute("currentPage",currentPage);
        modelMap.addAttribute("totalPages",totalPages);
        return "booking";
    }
}
