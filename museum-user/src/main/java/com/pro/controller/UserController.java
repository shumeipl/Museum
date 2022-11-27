package com.pro.controller;


import com.pro.pojo.Exhibits;
import com.pro.pojo.Photos;
import com.pro.pojo.User;
import com.pro.service.IExhibitsService;
import com.pro.service.IPhotosService;
import com.pro.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
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
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService userService;
   @Autowired
   private IExhibitsService exhibitsService;
    @Autowired
    private IPhotosService photosService;

    @ApiOperation(value = "登录")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);

        User user = userService.login(loginUser);
        HttpSession session = request.getSession();
        if (user != null) {
                //用户登录成功
                //将用户存入session
                session.setAttribute("user",user);
                //跳转页面
                return "index";
        }else{
            request.setAttribute("msg","用户名或密码错误");
            return "login";
        }
    }

    @ApiOperation(value = "通过id查询用户信息")
    @RequestMapping("/selfInfo")
    public String getSelfInfo(Integer userId, ModelMap modelMap){
        User self = userService.getUserById(userId);
        modelMap.addAttribute("self",self);
        return "selfInfo";
    }

    @ApiOperation(value = "用户修改信息页面")
    @RequestMapping("/updatePage")
    public String updatePage(Integer userId,ModelMap modelMap){
        User info = userService.getUserById(userId);
        modelMap.addAttribute("info",info);
        return "update";
    }

    @ApiOperation(value = "用户修改信息")
    @RequestMapping("/update")
    public String update(User user){
        userService.uadateUser(user);
        return "redirect:/users/updatePage";
    }

    @ApiOperation(value = "用户注册")
    @RequestMapping("/register")
    public String register(User user){
        userService.addUser(user);
        return "login";
    }

}
