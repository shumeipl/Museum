package com.pro.controller;


import com.pro.pojo.Collections;
import com.pro.pojo.Type;
import com.pro.service.ICollectionsService;
import com.pro.service.ITypeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @since 2022-11-25
 */
@Controller
@RequestMapping("/collections")
public class CollectionsController {

    @Autowired
    private ICollectionsService collectionsService;
    @Autowired
    private ITypeService typeService;

    @ApiOperation(value = "根据类型分页查询藏品" )
    @RequestMapping("getByTypePage")
    public String getByTypePage(@RequestParam(value = "type",required = false) String type,
                                @RequestParam(value = "currentPage",required = false)Integer currentPage,
                                @RequestParam(value = "pageSize",required = false)Integer pageSize, ModelMap modelMap){
        List<Type> types = typeService.getAllType();
        if(type == null){
            type = types.get(0).getTypeName();
        }
        if (currentPage == null){
            currentPage = 1;
        }
        if (pageSize == null){
            pageSize = 12;
        }
        List<Collections> collectionsList = collectionsService.getByType(type);
        int total = 0;
        if (collectionsList.size() % pageSize == 0){
            total = collectionsList.size() /pageSize;
        }else{
            total = (collectionsList.size()/pageSize)+ 1;
        }
        List<Collections> collections = collectionsService.getByTypePage(type, (currentPage-1)*pageSize, pageSize);
        modelMap.addAttribute("typeList",types);
        modelMap.addAttribute("collections",collections);
        modelMap.addAttribute("currentPage",currentPage);
        modelMap.addAttribute("total",total);
        modelMap.addAttribute("type",type);
        return "collection";
    }

    @ApiOperation(value = "根据id查询藏品")
    @RequestMapping("getCollectionById")
    public String getCollectionById(Integer collectionId, ModelMap modelMap){
        Collections collection = collectionsService.getCollectionById(collectionId);
        modelMap.addAttribute("collection",collection);
        return "collectionDetails";
    }


}
