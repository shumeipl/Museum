package com.pro.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pro.domain.Workers;
import com.pro.service.WorkerService;
import com.pro.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class WorkController {
    @Autowired
    private WorkerService workerService;

    /**
     * 直接点击创建工作账号
     * @return 包括可分配的员工工号
     */
    @GetMapping("insertWork")
    public R insertWork(Integer page, Integer size){
        return workerService.insertWorker(page,size);
    }

    /**
     * 模糊查找或页面初始化
     * @param page 当前页
     * @param size 容量
     * @param name 搜索时填入的值，可为空
     * @return
     */
    @GetMapping("selectAllWorkers")
    public IPage<Workers> selectAllWorkers(int page, int size, String name,String state){
        return workerService.selectAllWorkers(size,page,name,state);
    }

    @GetMapping("deleteWork")
    public R deleteWork(int work_id){
        return workerService.deleteWorker(work_id);
    }

    /**
     * 精准查找
     * @param work_id
     * @return
     */
    @GetMapping("selectWorkByID")
    public R selectWorkByID(int work_id){
        return workerService.selectOneWorker(work_id);
    }


    @GetMapping("toWorkerManage")
    public ModelAndView toWorkerManage(HttpServletRequest request, HttpServletResponse response){
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
                ModelAndView modelAndView = new ModelAndView("workerManage");
                return modelAndView;
            }
        }else {
            return new ModelAndView("manageLogin");
        }

    }

    @GetMapping("selectAllWorkersList")
    public List<Workers> selectAllWorkersList(){
        return workerService.selectAllWorkersList();
    }

}
