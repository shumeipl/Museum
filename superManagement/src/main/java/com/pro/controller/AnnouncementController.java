package com.pro.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pro.domain.Announcements;
import com.pro.service.AnnouncementService;
import com.pro.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AnnouncementController {
    @Autowired
    private AnnouncementService announcementService;
    @GetMapping("/toAnnouncementManager")
    public ModelAndView toAnnouncementManager(HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        if (cookies!=null){
            int sum = 0;
            for (Cookie cookie : cookies) {
                if ("identity".equals(cookie.getName())){
                    if ("manager".equals(cookie.getValue())){
                        sum++;
                        break;
                    }
                }
            }
            if (sum==0){
                return new ModelAndView("manageLogin");
            }else {
                for (Cookie cookie : cookies) {
                    cookie.setMaxAge(60*60);
                    response.addCookie(cookie);
                }
                ModelAndView modelAndView = new ModelAndView("/announcementManage");
                return modelAndView;
            }
        }else {
            return new ModelAndView("manageLogin");
        }

    }
//    添加公告
    @GetMapping("insertAnnouncement")
    @ResponseBody
    public R insertAnnouncement(Announcements announcements, HttpServletRequest request){

        return announcementService.insertAnnouncement(announcements);
    }
// 更新公告
@GetMapping("updateAnnouncement")
@ResponseBody
    public R updateAnnouncement(Announcements announcements){
        return announcementService.updateAnnouncement(announcements);
}
//    删除公告
    @GetMapping("deleteAnnouncement")
    @ResponseBody
    public R deleteAnnouncement(int a_id){
        return announcementService.deleteOneAnnouncement(a_id);
    }
//    获取所有公告
    @GetMapping("selectAllAnnouncement")
    @ResponseBody
    public IPage selectAllAnnouncement(int page,int size){
        return announcementService.selectAllAnnouncement(page,size);
    }

//    获取详细公告信息
//    @GetMapping("toDetailAnnouncement")
//    @ResponseBody
//    public ModelAndView toDetailAnnouncement(){
//        ModelAndView modelAndView = new ModelAndView("detailAnnouncement");
//        return modelAndView;
//    }
    @GetMapping("selectAnnouncementById")
    @ResponseBody
    public R selectAnnouncementById( int a_id){
        R r = announcementService.selectOneAnnouncement(a_id);
        return r;
    }
}
