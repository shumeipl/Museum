package com.pro.controller;


import com.pro.pojo.Likes;
import com.pro.service.ILikesService;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xhw
 * @since 2022-11-22
 */
@Controller
@RequestMapping("/likes")
public class LikesController {

    @Autowired
    private ILikesService likesService;

    @ApiOperation(value = "根据id查找收藏")
    @RequestMapping("/allLikes")
    public String getAllLikesById(Integer userId, ModelMap modelMap){
        List<Likes> allLikes = likesService.getAllLikesById(userId);
        if (allLikes.size() == 0){
            modelMap.addAttribute("tap","您还没有收餐品，请先收藏");
            return "empty";
        }else {
            modelMap.addAttribute("likeList", allLikes);
            return "likes";
        }
    }


}
