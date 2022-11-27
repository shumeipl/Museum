package com.pro.controller;


import com.pro.pojo.Announcements;
import com.pro.service.IAnnouncementsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xhw
 * @since 2022-11-23
 */
@Controller
@RequestMapping("announcements")
public class AnnouncementsController {

    @Autowired
    private IAnnouncementsService announcementsService;

    @ApiOperation(value = "查询所有公告信息")
    @RequestMapping("allAnnouncements")
    public String getAllAnnouncements(ModelMap modelMap){
        List<Announcements> allAnnouncements = announcementsService.getAllAnnouncements();
        modelMap.addAttribute("announcementsList",allAnnouncements);
        return "announcement";
    }

    @ApiOperation(value = "分页查询")
    @RequestMapping("getAnnouncementsByPage")
    public String getAnnouncementsByPage(@RequestParam(value = "currentPage",required = false)Integer currentPage,@RequestParam(value = "pageSize",required = false)Integer pageSize, ModelMap modelMap){
        if (currentPage == null){
            currentPage = 1;
        }
        if (pageSize == null){
            pageSize = 10;
        }
        List<Announcements> allAnnouncements = announcementsService.getAllAnnouncements();
        List<Announcements> announcementsByPage = announcementsService.getAnnouncementsByPage((currentPage-1)*pageSize,pageSize);
        int pages = 0;
        if(allAnnouncements.size()%pageSize==0){
            pages = allAnnouncements.size() / pageSize;
        }else{
            pages = (allAnnouncements.size()/pageSize)+1;
        }
        modelMap.addAttribute("announcementsPageList",announcementsByPage);
        modelMap.addAttribute("pages",pages);
        modelMap.addAttribute("currentPage",currentPage);
        return "announcement";
    }

    @ApiOperation(value = "根据id查询公告")
    @RequestMapping("getAnnouncementById")
    public String getAnnouncementById(Integer AId,ModelMap modelMap){
        Announcements announcement = announcementsService.getAnnouncementById(AId);
        modelMap.addAttribute("announcement",announcement);
        return "announcementDetail";
    }

}
