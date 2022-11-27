package com.example.workers.controller;

//import com.example.workers.pojo.Workers;
import com.example.workers.pojo.*;
import com.example.workers.service.WorkerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/worker")
public class WorkerController {
    static int id;
    Workers workers;
    @Autowired
    private WorkerServiceImp ws;
    @RequestMapping("/t")
//    @ResponseBody
    public String test1(){
        return "Login";
    }
    @PostMapping("/Check")

    public String Check(HttpServletRequest request) throws ServletException, IOException {
        id = Integer.parseInt(request.getParameter("id"));
        String password = request.getParameter("password");
        Workers workers = new Workers(id,password);
        if(ws.Login(workers)){
            base(request);
            request.setAttribute("flag",0);
            request.setAttribute("currentPagef1",1);
            request.setAttribute("currentPagef2",1);
            request.setAttribute("currentPagef3",1);
            request.setAttribute("currentPagef4",1);


            return "Index";
        }
        request.setAttribute("ok",0);
        return "Login";
    }
//    修改信息
    @PostMapping("/Update")
    public String Update(HttpServletRequest request){
        System.out.println("OK!");
        String phone = request.getParameter("phone");
        if(ws.Update(id,phone)){
           base(request);
            request.setAttribute("flag",6);
            request.setAttribute("currentPagef1",1);
            request.setAttribute("currentPagef2",1);
            request.setAttribute("currentPagef3",1);
            request.setAttribute("currentPagef4",1);
            return "Index";
        }
        base(request);
        request.setAttribute("currentPagef1",1);
        request.setAttribute("currentPagef2",1);
        request.setAttribute("currentPagef3",1);
        request.setAttribute("currentPagef4",1);
        request.setAttribute("flag",6);
        System.out.println("更新失败！");
        return "Index";
    }
    public  void  base(HttpServletRequest request){
        Workers workerInfo=ws.QueryInfo(id);
        request.setAttribute("workerId",id);
        request.setAttribute("name",workerInfo.getName());
        request.setAttribute("sex",workerInfo.getSex());
        request.setAttribute("avator",workerInfo.getAvatar());
        request.setAttribute("phone",workerInfo.getPhone());
        request.setAttribute("password",workerInfo.getPassword());
        request.setAttribute("ok",1);
    }

//    修改密码
    @RequestMapping("/UpdatePW")
    public String updatePW(HttpServletRequest request){
        String newPassword = request.getParameter("newPassword");
        String TwiceNewPassword = request.getParameter("TwiceNewPassword");
        if (newPassword.equals(TwiceNewPassword)) {
            if (ws.UpdatePW(id, newPassword)) {
                base(request);
                request.setAttribute("flag", 7);
                request.setAttribute("currentPagef1",1);
                request.setAttribute("currentPagef2",1);
                request.setAttribute("currentPagef3",1);
                request.setAttribute("currentPagef4",1);
                return "Login";
            }
        }
        else {
            base(request);
            request.setAttribute("NotSame",1);
            request.setAttribute("flag",7);
            request.setAttribute("currentPagef1",1);
            request.setAttribute("currentPagef2",1);
            request.setAttribute("currentPagef3",1);
            request.setAttribute("currentPagef4",1);
            return "Index";
        }
        return null;
    }

//分页展示展览信息
    @GetMapping( "/displayExihibts/{currentPage}")
    public String displayExihibts(@PathVariable("currentPage") String currentPage, HttpServletRequest request){
        int MaxPageExhibit=ws.MaxPagExhibits();
        int cP = Integer.parseInt(currentPage);
        List<Exhibits> exhibitsList = ws.displayExhibits(cP);
        if (exhibitsList!=null&&exhibitsList.size()!=0){
            base(request);
            int n = MaxPageExhibit%20==0?MaxPageExhibit/20:MaxPageExhibit/20+1;
            if (n==0){
                n=1;
            }
            System.out.println(exhibitsList);
            System.out.println(n);
            request.setAttribute("MaxPageExhibit",n);
            request.setAttribute("exhibits",exhibitsList);
            request.setAttribute("flag",1);
            request.setAttribute("currentPagef1",currentPage);
            request.setAttribute("currentPagef2",1);
            request.setAttribute("currentPagef3",1);
            request.setAttribute("currentPagef4",1);
            return "Index";
        }
        base(request);
        request.setAttribute("currentPagef1",1);
        request.setAttribute("currentPagef2",1);
        request.setAttribute("currentPagef3",1);
        request.setAttribute("currentPagef4",1);
        request.setAttribute("flag",1);
        return "Index";
    }


//    分页展示预约记录
@GetMapping( "/displayBookings/{currentPage}")
public String displayBookings(@PathVariable("currentPage") String currentPage, HttpServletRequest request){
    int cP = Integer.parseInt(currentPage);
    int MaxPageBooking=ws.MaxPageBooking();
    List<Bookings> bookingsList = ws.displayBookings(cP);
    System.out.println("booking");
    System.out.println(bookingsList);
    if (bookingsList!=null&&bookingsList.size()!=0){
        base(request);
        int n = MaxPageBooking%20==0?MaxPageBooking/20:MaxPageBooking/20+1;
        if (n==0){
            n=1;
        }
        request.setAttribute("MaxPageBooking",n);
        request.setAttribute("flag",3);
        request.setAttribute("bookings",bookingsList);
        request.setAttribute("currentPagef2",currentPage);
        request.setAttribute("currentPagef1",1);
        request.setAttribute("currentPagef3",1);
        request.setAttribute("currentPagef4",1);
        return "Index";
    }
    base(request);
    request.setAttribute("currentPagef1",1);
    request.setAttribute("currentPagef2",1);
    request.setAttribute("currentPagef3",1);
    request.setAttribute("currentPagef4",1);
    request.setAttribute("flag",3);
    return "Index";
}
//通过搜索场馆类型
@PostMapping ( "/displayExhibitsByType")
    public String displayExhibitsByType( HttpServletRequest request){
        String type = request.getParameter("type");
    List<Exhibits> exhibits = ws.displayExhibitsByType(type);
    if (exhibits!=null&&exhibits.size()!=0){
        base(request);
        request.setAttribute("flag",1);
        request.setAttribute("exhibits",exhibits);
        request.setAttribute("currentPagef2",1);
        request.setAttribute("currentPagef1",1);
        request.setAttribute("currentPagef3",1);
        request.setAttribute("currentPagef4",1);
        return "Index";
    }
    base(request);
    request.setAttribute("flag",1);
    request.setAttribute("currentPagef2",1);
    request.setAttribute("currentPagef1",1);
    request.setAttribute("currentPagef3",1);
    request.setAttribute("currentPagef4",1);
    return "Index";
    }
//    通过搜索员工编号显示排班信息
@PostMapping ( "/displayTimesPlanById")
public String displayTimesPlanById(HttpServletRequest request){
        String id = request.getParameter("id");
    if (id!="") {
        Integer Id = Integer.parseInt(id);
        List<TimesPlan> timesPlan = ws.displayTimesPlanById(Id);
        if (timesPlan != null && timesPlan.size() != 0) {
            base(request);
            request.setAttribute("flag", 2);
            request.setAttribute("timesPlan", timesPlan);
            request.setAttribute("currentPagef2", 1);
            request.setAttribute("currentPagef1", 1);
            request.setAttribute("currentPagef3", 1);
            request.setAttribute("currentPagef4", 1);
            return "Index";
        }
    }
    base(request);
    request.setAttribute("flag",2);
    request.setAttribute("currentPagef2",1);
    request.setAttribute("currentPagef1",1);
    request.setAttribute("currentPagef3",1);
    request.setAttribute("currentPagef4",1);
    return "Index";
}
// 通过搜索场馆名显示预约记录
@PostMapping( "/displayBookingsByVenueName")
public String displayBookingsByVenueName(HttpServletRequest request){
        String name = request.getParameter("venueName");
    List<Bookings> bookings = ws.displayBookingsByVenueName(name);
    if (bookings!=null&&bookings.size()!=0){
        base(request);
        request.setAttribute("flag",3);
        request.setAttribute("bookings",bookings);
        request.setAttribute("currentPagef2",1);
        request.setAttribute("currentPagef1",1);
        request.setAttribute("currentPagef3",1);
        request.setAttribute("currentPagef4",1);
        return "Index";
    }
    base(request);
    request.setAttribute("flag",3);
    request.setAttribute("currentPagef2",1);
    request.setAttribute("currentPagef1",1);
    request.setAttribute("currentPagef3",1);
    request.setAttribute("currentPagef4",1);
    return "Index";
}
//    展示的排班记录
@GetMapping("/displayTimesPlan/{currentPage}")
public String displayTimesPlan(@PathVariable("currentPage") String currentPage, HttpServletRequest request){
    int cP = Integer.parseInt(currentPage);
    int MaxPageTimesPlan=ws.MaxPageTimePlan();
    List<TimesPlan> timesPlanList = ws.displayTimePlan(cP);
    System.out.println(timesPlanList);
    if (timesPlanList!=null&&timesPlanList.size()!=0){
        base(request);
        int n = MaxPageTimesPlan%20==0?MaxPageTimesPlan/20:MaxPageTimesPlan/20+1;
        if (n==0){
            n=1;
        }
        request.setAttribute("MaxPageTimesPlan",n);
        request.setAttribute("flag",2);
        request.setAttribute("timesPlan",timesPlanList);
        request.setAttribute("currentPagef3",currentPage);
        request.setAttribute("currentPagef1",1);
        request.setAttribute("currentPagef2",1);
        request.setAttribute("currentPagef4",1);
        return "Index";
    }
    base(request);
    request.setAttribute("flag",2);
    request.setAttribute("currentPagef3",1);
    request.setAttribute("currentPagef1",1);
    request.setAttribute("currentPagef2",1);
    request.setAttribute("currentPagef4",1);
    return "Index";
}
//    分页展示参观人数
@GetMapping("/displayAttendencePlan/{currentPage}")
public String displayVistors(@PathVariable("currentPage") String currentPage, HttpServletRequest request){
    int cP = Integer.parseInt(currentPage);
    int MaxPageVistors= ws.MaxPageVisitors();
    List<Attendence> AttenedenceList = ws.Attendences();
    if (AttenedenceList!=null&&AttenedenceList.size()!=0){
        base(request);
        int n = MaxPageVistors%20==0?MaxPageVistors/20:MaxPageVistors/20+1;
        if (n==0){
            n=1;
        }
        request.setAttribute("MaxPageVistors",n);
        request.setAttribute("flag",8);
        request.setAttribute("Attendences",AttenedenceList);
        request.setAttribute("currentPagef4",currentPage);
        request.setAttribute("currentPagef1",1);
        request.setAttribute("currentPagef2",1);
        request.setAttribute("currentPagef3",1);
        return "Index";
    }
    base(request);
    request.setAttribute("currentPagef1",1);
    request.setAttribute("currentPagef2",1);
    request.setAttribute("currentPagef3",1);
    request.setAttribute("currentPagef4",1);
    request.setAttribute("flag",8);
    return "Index";
}
}
