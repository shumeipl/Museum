package com.pro.controller;

import com.pro.domain.Photos;
import com.pro.service.PhotoService;
import com.pro.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class PhotoController {
    @Autowired
    private PhotoService photoService;

    @PostMapping("insertPhoto")
    public R insertPhoto(Photos photos){
        return photoService.insertPhotos(photos);
    }

    @GetMapping("updatePhoto")
    public R updatePhoto(Photos photos){
        return photoService.updatePhoto(photos);
    }

    @GetMapping("deletePhoto")
    public R deletePhoto(int photo_id){
        return photoService.deletePhotoById(photo_id);
    }

    @GetMapping("selectAllPhotos")
    public R selectAllPhotos(){
        return photoService.selectAllPhotos();
    }

    @GetMapping("toPhotoManage")
    public ModelAndView toPhotoManage(HttpServletRequest request, HttpServletResponse response){
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
                ModelAndView modelAndView = new ModelAndView("photoManage");
                return modelAndView;
            }
        }else {
            return new ModelAndView("manageLogin");
        }

    }

}
