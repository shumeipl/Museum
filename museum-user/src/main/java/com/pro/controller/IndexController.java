package com.pro.controller;

import com.pro.pojo.*;
import com.pro.service.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller

public class IndexController {

    @Autowired
    private IExhibitsService exhibitsService;
    @Autowired
    private IPhotosService photosService;
    @Autowired
    private IVenuesService venuesService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IAnnouncementsService announcementsService;
    @Autowired
    private ICollectionsService collectionsService;


    @ApiOperation(value = "进入首页")
    @RequestMapping("index")
    public String toIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Exhibits>  exhibits = exhibitsService.getExhibitsByStatePage(1, 0, 5);
        List<Photos> photos = photosService.getPhotos();
        List<Collections> collections = collectionsService.getByTypePage("瓷器", 0, 7);
        //modelMap.addAttribute("exhibitsList",allExhibits);
        List<Venues> allVenues = venuesService.getAllVenues();
        List<Announcements> announcements= announcementsService.getAnnouncementsByPage(0, 5);
        session.setAttribute("venueList",allVenues);
        session.setAttribute("photosList",photos);
        session.setAttribute("announcements",announcements);
        session.setAttribute("exhibits",exhibits);
        session.setAttribute("collections",collections);
        return "index";
    }


}
