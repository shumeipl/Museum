package com.pro.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pro.domain.Manages;
import com.pro.service.ManageService;
import com.pro.util.R;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class ManageController {
    @Autowired
    private ManageService manageService;

    @GetMapping("/toManagerLogin")
    public ModelAndView toManagerLogin(HttpServletRequest request,HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView("manageLogin");
        Cookie[] cookies = request.getCookies();
        Manages manages = new Manages();
        if (cookies!=null){
            for (Cookie cookie : cookies) {
                if ("manage_id".equals(cookie.getName())){
                    int id = Integer.parseInt(cookie.getValue());
                    manages.setManage_id(id);
                }
                if ("manage_password".equals(cookie.getName())){
                    manages.setPassword(cookie.getValue());
                }
            }
        }
        if (manages!=null){
            try {
                Manages selectOne = manageService.selectOne(manages.getManage_id());
                if (selectOne != null) {
                    String pass = DigestUtils.md5Hex(manages.getPassword() + (selectOne.getSlat() + selectOne.getSlat()));
                    if (selectOne.getPassword().equals(pass)) {
                            String manage_id = String.valueOf(manages.getManage_id());
                            Cookie id = new Cookie("manage_id",manage_id);
                            Cookie password = new Cookie("manage_password",manages.getPassword());
                            id.setMaxAge(60*60);
                            password.setMaxAge(60*60);
                            response.addCookie(id);
                            response.addCookie(password);
                        Cookie identity = new Cookie("identity","manager");
                        identity.setMaxAge(60*60);
                        response.addCookie(identity);
                        return new ModelAndView("manageHome");
                    } else {
                        return modelAndView;
                    }

                } else {
                    return modelAndView;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return modelAndView;
            }
        }
        return modelAndView;
    }


    /**
     * ??????
     *
     * @param manages
     * @return
     */
    @PostMapping("/manageLogin")
    public R manageLogin(Manages manages, String cook, MultipartFile img, HttpServletResponse response) {
        try {
            Manages selectOne = manageService.selectOne(manages.getManage_id());

            System.out.println("?????????"+img);
            if (selectOne != null) {
                String pass = DigestUtils.md5Hex(manages.getPassword() + (selectOne.getSlat() + selectOne.getSlat()));
                if (selectOne.getPassword().equals(pass)) {
                    if ("???".equals(cook)){
                        String manage_id = String.valueOf(manages.getManage_id());
                        Cookie id = new Cookie("manage_id",manage_id);
                        Cookie password = new Cookie("manage_password",manages.getPassword());
                        id.setMaxAge(60*60);
                        password.setMaxAge(60*60);
                        response.addCookie(id);
                        response.addCookie(password);
                    }
                    Cookie identity = new Cookie("identity","manager");
                    identity.setMaxAge(60*60);
                    response.addCookie(identity);
                    return new R("200", "????????????", selectOne);
                } else {
                    return new R("300", "?????????????????????");
                }

            } else {
                return new R("400", "????????????");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new R("500", "?????????????????????");
        }

    }

    /**
     * ???????????????
     *
     * @return
     */
    @GetMapping("/insertManage")
    public R insertManage() {
        Manages manages = new Manages();
        manages.setPassword("111");
        try {
            manageService.insertManage(manages);
        } catch (Exception e) {
            e.printStackTrace();
            return new R("300", "????????????");
        }
        return new R("200", "????????????");
    }


    /**
     * ????????????
     * @param manages ?????????
     * @param oldPass ?????????
     * @return
     */
    @GetMapping("/updatePassword")
    public R updatePassword(Manages manages, String oldPass) {
        try {
            Manages selectOne = manageService.selectOne(manages.getManage_id());
            if (selectOne!=null){
                String pass = DigestUtils.md5Hex(oldPass+(selectOne.getSlat()+selectOne.getSlat()));
                if (selectOne.getPassword().equals(pass)){
                    pass = DigestUtils.md5Hex(manages.getPassword()+(selectOne.getSlat()+selectOne.getSlat()));
                    selectOne.setPassword(pass);
                    manageService.updatePassword(selectOne);
                    return new R("200","????????????",selectOne);
                }else {
                    return new R("444","???????????????");
                }
            }else {
                return new R("400","?????????????????????");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new R("500","?????????????????????");
        }
    }

    /**
     * ???????????????
     * @param delete_id ????????????1???????????????
     * @return
     */
    @GetMapping("/deleteManager")
    public R deleteManager(HttpServletRequest request,Integer delete_id){
        Cookie[] cookies = request.getCookies();
        int manage_id = 0;
        if (cookies!=null && cookies.length>0){
            for (Cookie cookie : cookies) {
                if ("manage_id".equals(cookie.getName())){
                    manage_id = Integer.parseInt(cookie.getValue());
                }
            }
        }
        if (manage_id!=0&&delete_id!=0){
            if (manage_id<delete_id){
                try {
                    Manages selectOne = manageService.selectOne(delete_id);
                    if (selectOne!=null){
                        manageService.deleteManage(delete_id);
                        return new R("200","?????????");
                    }else {
                        return new R("300","??????????????????");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return new R("300","??????????????????");
                }
            }else {
                return new R("400","????????????????????????????????????");
            }
        }else {
            return new R("300","??????????????????");
        }
    }

    @GetMapping("/manageHome")
    public ModelAndView manageHome(){
        ModelAndView modelAndView = new ModelAndView("manageHome");
        return modelAndView;
    }

    @GetMapping("/getAllManage")
    public IPage<Manages> getAllManage(int page,int size){
       return manageService.selectAllManage(page,size);
    }


    @GetMapping("toManagerManage")
    public ModelAndView toManagerManage(HttpServletRequest request, HttpServletResponse response){
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
                ModelAndView modelAndView = new ModelAndView("managerManage");
                return modelAndView;
            }
        }else {
            return new ModelAndView("manageLogin");
        }

    }

}
