package com.pro.controller;


import com.pro.pojo.Venues;
import com.pro.service.IVenuesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.SplittableRandom;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xhw
 * @since 2022-11-25
 */
@Controller
@RequestMapping("venues")
public class VenuesController {

    @Autowired
    private IVenuesService venuesService;

    @ApiOperation(value = "查询所有馆")
    @RequestMapping("getAllVenues")
    public String getAllVenues(ModelMap modelMap){
        List<Venues> allVenus = venuesService.getAllVenues();
        return "service";
    }

    @ApiOperation(value = "根据名字查询")
    @RequestMapping("getVenueByName")
    public String getVenueByName(String venueName,ModelMap modelMap){

        List<Venues> allVenues = venuesService.getAllVenues();
        String name = allVenues.get(0).getVenueName();
        if (venueName ==null || venueName == ""){
            venueName = "求是馆";
        }
        modelMap.addAttribute("venues",allVenues);
        Venues venue = venuesService.getVenueByName(venueName);
        modelMap.addAttribute("venue",venue);
        return "service";
    }

}
