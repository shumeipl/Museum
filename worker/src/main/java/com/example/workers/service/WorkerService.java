package com.example.workers.service;

import com.example.workers.pojo.*;

import java.util.List;

public interface WorkerService {
    boolean Login(Workers workers);
    Workers QueryInfo(int id);
    boolean Update(int id,String avator);
//    修改密码
    boolean UpdatePW(int id ,String password);
    //分页展示展览信息
    List<Exhibits> displayExhibits(int currentPage);
//    分页展示预约记录
    List<Bookings> displayBookings(int currentPage);
//    展示自己的排班记录
    List<TimesPlan> displayTimePlan(int id);
//    分页展示参观人数
    List<Attendence> Attendences();
    int MaxPagExhibits();
    int MaxPageBooking();
    int MaxPageVisitors();
    int MaxPageTimePlan();

    List<Exhibits> displayExhibitsByType(String type);
    List<TimesPlan> displayTimesPlanById(int ID);
    List<Bookings> displayBookingsByVenueName(String name);


}
