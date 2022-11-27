package com.example.workers.service;


import com.example.workers.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.workers.dao.*;

import java.util.ArrayList;
import java.util.List;
@Service
public class WorkerServiceImp implements WorkerService {
    @Autowired
    private WorkersMapper wm;
    @Autowired
    private ExhibitsMapper em;
    @Autowired
    private BookingsMapper bm;
    @Autowired
    private TimesPlanMapper tpm;
    @Autowired
    private AttendenceMapper am;
    int pagesize=20;
    @Override
    public boolean Login(Workers workers) {
        WorkersExample we = new WorkersExample();
        we.createCriteria().andWorkerIdEqualTo(workers.getWorkerId())
                .andPasswordEqualTo(workers.getPassword());
        List<Workers> workersList = wm.selectByExample(we);
        return workersList!=null&&workersList.size()==1;
    }

    @Override
    public Workers QueryInfo(int id) {
        WorkersExample we = new WorkersExample();
        we.createCriteria().andWorkerIdEqualTo(id);
        ArrayList<Workers> workers  = (ArrayList<Workers>) wm.selectByExample(we);
        return workers.get(0);
    }

    @Override
    public boolean Update(int id, String phone) {
        Workers worker = new Workers(null,null,null,phone,null,null,null);
        WorkersExample we = new WorkersExample();
        we.createCriteria().andWorkerIdEqualTo(id);
        int res = wm.updateByExampleSelective(worker,we);
        System.out.println(res);
        if (res!=0){
            return true;
        }
        return false;
    }

    @Override
    public boolean UpdatePW(int id, String password) {
        Workers worker = new Workers(id,password);
        WorkersExample we = new WorkersExample();
        we.createCriteria().andWorkerIdEqualTo(id);
        int res = wm.updateByExampleSelective(worker,we);
        if (res!=0){
            return true;
        }
        return false;
    }

    //鍒嗛〉灞曠ず灞曡淇℃伅
    @Override
    public List<Exhibits> displayExhibits(int currentPage) {
        ExhibitsExample ee = new ExhibitsExample();
        WorkersExample we = new WorkersExample();
        we.createCriteria().andWorkerIdIsNotNull();
        List<Workers> workers = wm.selectByExample(we);
        ee.createCriteria().andExhibitIdBetween((currentPage-1)*pagesize,currentPage*pagesize);
        List<Exhibits> exhibits = em.selectByExample(ee);
        for (Exhibits e: exhibits){
            if (e.getWorkId()==workers.get(0).getWorkerId()){
                e.setPhone(workers.get(0).getPhone());
            }
        }
        System.out.println(exhibits);
        return exhibits;
    }
    //鍒嗛〉灞曠ず棰勭害淇℃伅
    @Override
    public List<Bookings> displayBookings(int currentPage) {
        BookingsExample be = new BookingsExample();
        be.createCriteria().andBookingIdBetween((currentPage-1)*pagesize,currentPage*pagesize);
        List<Bookings> bookings =  bm.selectByExample(be);
        return bookings;
    }
    //灞曠ず鎺掔彮鏃堕棿
    @Override
    public List<TimesPlan> displayTimePlan(int currentPage) {
        TimesPlanExample tmp = new TimesPlanExample();
        tmp.createCriteria().andTimeIdBetween((currentPage-1)*pagesize,currentPage*pagesize);
        List<TimesPlan> timesPlans = tpm.selectByExample(tmp);
        System.out.println("timesPlans"+timesPlans);
        return timesPlans;
    }
    //灞曠ず鍙傚姞浜烘暟
    @Override
    public List<Attendence> Attendences() {
        List<Attendence> attendenceList=am.selectNums();
        return attendenceList;
    }

    @Override
    public int MaxPagExhibits() {
        ExhibitsExample ee = new ExhibitsExample();
        ee.createCriteria().andExhibitIdIsNotNull();
        List<Exhibits> exhibits = em.selectByExample(ee);
        return exhibits.size();
    }

    @Override
    public int MaxPageBooking() {
        BookingsExample be = new BookingsExample();
        be.createCriteria().andBookingIdIsNotNull();
        List<Bookings> bookings = bm.selectByExample(be);
        return bookings.size();
    }

    @Override
    public int MaxPageVisitors() {
        List<Attendence> attendenceList=am.selectNums();
        return attendenceList.size();
    }

    @Override
    public int MaxPageTimePlan() {
        TimesPlanExample tmp = new TimesPlanExample();
        tmp.createCriteria().andTimeIdIsNotNull();
        List<TimesPlan> timesPlans = tpm.selectByExample(tmp);
        return timesPlans.size();
    }

    @Override
    public List<Exhibits> displayExhibitsByType(String type) {
        ExhibitsExample ee = new ExhibitsExample();
        ee.createCriteria().andTypeEqualTo(type);
        List<Exhibits> exhibits= em.selectByExample(ee);
        return exhibits;
    }

    @Override
    public List<TimesPlan> displayTimesPlanById(int ID) {
        TimesPlanExample tpe = new TimesPlanExample();
        tpe.createCriteria().andWorkIdEqualTo(ID);
        List<TimesPlan> timesPlans = tpm.selectByExample(tpe);
        return timesPlans;
    }

    @Override
    public List<Bookings> displayBookingsByVenueName(String name) {
        BookingsExample be = new BookingsExample();
        be.createCriteria().andVenueNameEqualTo(name);
        List<Bookings> bookings= bm.selectByExample(be);
        return bookings;
    }


}
