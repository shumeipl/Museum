package com.pro.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pro.domain.TimePlans;
import com.pro.service.TimePlanService;
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
public class TimePlanController {
    @Autowired
    private TimePlanService timePlanService;

    @GetMapping("insertTimePlan")
    @ResponseBody
    public R insertTimePlan(TimePlans timePlans){
        return timePlanService.insertTimePlan(timePlans);
    }

    @GetMapping("updateTimePlan")@ResponseBody
    public R updateTimePlan(TimePlans timePlans){
        return timePlanService.updateTimePlan(timePlans);
    }

    @GetMapping("deleteTimePlan")@ResponseBody
    public R deleteTimePlan(int time_id){
        return timePlanService.delete(time_id);
    }

    @GetMapping("selectAllTimePlan")@ResponseBody
    public IPage<TimePlans> selectAllTimePlan(int page,int size,Integer exhibit_id){
        return timePlanService.selectAllTimePlans(page,size,exhibit_id);
    }

    @GetMapping("selectOneTimePlan")@ResponseBody
    public R selectOneTimePlan(int time_id){
        return timePlanService.selectOneTimePlan(time_id);
    }

    @GetMapping("toTimePlan")
    public ModelAndView toTimePlan(HttpServletRequest request , HttpServletResponse response){
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
                ModelAndView modelAndView = new ModelAndView("timeTable");
                return modelAndView;
            }
        }else {
            return new ModelAndView("manageLogin");
        }

    }
}
