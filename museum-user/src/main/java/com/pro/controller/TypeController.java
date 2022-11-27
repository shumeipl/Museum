package com.pro.controller;


import com.pro.pojo.Type;
import com.pro.service.ITypeService;
import io.swagger.annotations.ApiOperation;
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
 * @since 2022-11-25
 */
@Controller
@RequestMapping("type")
public class TypeController {

    @Autowired
    private ITypeService typeService;

    @ApiOperation(value = "查询所有藏品类型")
    @RequestMapping("getAllType")
    public String getAllType(ModelMap modelMap){
        List<Type> allType = typeService.getAllType();
        modelMap.addAttribute("typeList",allType);
        return "collection";
    }


}
