package com.pro.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pro.domain.Exhibits;
import com.pro.service.ExhibitService;
import com.pro.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class ExhibitController {
    @Autowired
    private ExhibitService exhibitService;

    @GetMapping("insertExhibit")
    @ResponseBody
    public R insertExhibit(Exhibits exhibits){
        return exhibitService.insertExhibit(exhibits);
    }

    @GetMapping("updateExhibit")@ResponseBody
    public R updateExhibit(Exhibits exhibits){
        return exhibitService.updateExhibit(exhibits);
    }

    @GetMapping("deleteExhibit")@ResponseBody
    public R deleteExhibit(int exhibit_id){
        return exhibitService.deleteExhibit(exhibit_id);
    }

    @GetMapping("selectAllExhibit")@ResponseBody
    public IPage<Exhibits> selectAllExhibit(int page,int size){
        return exhibitService.selectAllExhibit(page,size);
    }

    @GetMapping("selectAllExhibitOfState")@ResponseBody
    public IPage<Exhibits> selectAllExhibitOfState(int page, int size, String venue_name){
        return exhibitService.selectAllExhibitOfState(page,size,venue_name);
    }

    @GetMapping("selectOneExhibit")@ResponseBody
    public R selectOneExhibit(int exhibit_id){
        return exhibitService.selectOneExhibit(exhibit_id);
    }

    @GetMapping("toExhibitManage")
    public ModelAndView toExhibitManage(HttpServletRequest request, HttpServletResponse response){
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
                ModelAndView modelAndView = new ModelAndView("exhibitManage");
                return modelAndView;
            }
        }else {
            return new ModelAndView("manageLogin");
        }

    }

    @GetMapping("selectAllExhibitList")@ResponseBody
    public List<Exhibits> selectAllExhibitList(){
        return exhibitService.selectAllExhibitList();
    }

}
