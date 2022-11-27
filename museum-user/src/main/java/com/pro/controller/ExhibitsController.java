package com.pro.controller;


import com.pro.pojo.Exhibits;
import com.pro.pojo.Venues;
import com.pro.service.IExhibitsService;
import com.pro.service.IVenuesService;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.PrintWriter;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xhw
 * @since 2022-11-25
 */
@Controller
@RequestMapping("exhibits")
public class ExhibitsController {

    @Autowired
    private IExhibitsService exhibitsService;
    @Autowired
    private IVenuesService venuesService;

    @ApiOperation(value = "根据状态分页查询展览")
    @RequestMapping("getExhibitsByStatePage")
    public String getExhibitsByStatePage(@RequestParam(value = "state",required = false)Integer state,
                                         @RequestParam(value = "currentPage",required = false)Integer currentPage,
                                         @RequestParam(value = "pageSize",required = false)Integer pageSize, ModelMap modelMap){
        if (state == null){
            state = 3;
        }
        if(currentPage == null){
            currentPage = 1;
        }
        if (pageSize == null){
            pageSize = 10;
        }
        List<Exhibits> exhibitsByState = exhibitsService.getExhibitsByState(state);
        int totalPages = 0;
        if(exhibitsByState.size()%pageSize == 0){
            totalPages = exhibitsByState.size() / pageSize;
        }else if(exhibitsByState.size() % pageSize != 0){
            totalPages = exhibitsByState.size() / pageSize + 1;
        }
        List<Exhibits> exhibits = exhibitsService.getExhibitsByStatePage(state, (currentPage - 1) * pageSize, pageSize);
        modelMap.addAttribute("totalPages",totalPages);
        modelMap.addAttribute("currentPage",currentPage);
        modelMap.addAttribute("exhibits",exhibits);
        modelMap.addAttribute("state",state);
        return "exhibit";

    }

    @ApiOperation(value = "根据id查询展览")
    @RequestMapping("getExhibitById")
    public String getExhibitById(Integer exhibitId,ModelMap modelMap){
        Exhibits exhibit = exhibitsService.getExhibitById(exhibitId);
        modelMap.addAttribute("exhibit",exhibit);
        return "exhibitDetails";
    }

    @ApiOperation(value = "条件查询")
    @RequestMapping("byCondition")
    public String getExhibitByStateRange(ModelMap modelMap){

        List<Exhibits> exhibitList = exhibitsService.getExhibitsByStateRange();
        modelMap.addAttribute("exhibitList",exhibitList);
        return "exhibitBooking";
    }

    @ApiOperation(value = "根据id查询展览")
    @RequestMapping("getExhibitById2")
    public String getExhibitById2(@RequestParam(value = "exhibitId",required = false)Integer exhibitId,
                                  @RequestParam(value = "venueId",required = false)Integer venueId,
                                  @RequestParam(value = "userId")Integer userId, ModelMap modelMap){
        Exhibits exhibit = exhibitsService.getExhibitById(exhibitId);
        Venues venue = venuesService.getVenueById(venueId);
        modelMap.addAttribute("exhibit",exhibit);
        modelMap.addAttribute("venue",venue);
        if (userId == null){
            return "login";
        }
        return "bookingDetail";
    }
}
