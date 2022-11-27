package com.pro.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pro.domain.Collections;
import com.pro.service.CollectionService;
import com.pro.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class CollectionController {
    @Autowired
    private CollectionService collectionService;

    @GetMapping("insertCollection")
    public R insertCollection(Collections collections){
        return collectionService.insertCollection(collections);
    }

    @GetMapping("updateCollection")
    public R updateCollection(Collections collections){
        return collectionService.updateCollection(collections);
    }

    @GetMapping("deleteCollection")
    public R deleteCollection(int collection_id){
        return collectionService.deleteCollection(collection_id);
    }

    @GetMapping("selectOneCollection")
    public R selectOneCollection(int collection_id){
        return collectionService.selectOneCollection(collection_id);
    }

    @GetMapping("selectAllCollection")
    public IPage<Collections> selectAllCollection(int page,int size,String name,String venue_name,String type,String state){
        return collectionService.selectAllCollection(page,size,name,state);
    }

    @GetMapping("toCollectionManage")
    public ModelAndView toCollectionManage(HttpServletRequest request, HttpServletResponse response){
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
                ModelAndView modelAndView = new ModelAndView("collectionManage");
                return modelAndView;
            }
        }else {
            return new ModelAndView("manageLogin");
        }

    }

}
