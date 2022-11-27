package com.pro.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pro.domain.Workers;
import com.pro.mapper.WorkerMapper;
import com.pro.util.R;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class WorkerServiceImpl implements WorkerService {
    @Autowired
    private WorkerMapper workerMapper;
    @Override
    public R insertWorker(Integer page,Integer size) {
        Workers workers = new Workers();
        Random random = new Random();
        int salt = random.nextInt(8999)+1000;
        String password = DigestUtils.md5Hex("000"+salt);
        workers.setPassword(password);
        workers.setSalt(salt);
        workers.setPhone("请输入电话号码"+new Date().getTime());
        IPage<Workers> selectList = null;
        try {
            workerMapper.insert(workers);
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.like("phone","请输入电话号码");
            try {
                Page<Workers> workersPage = new Page<>(page,size);
                 selectList = workerMapper.selectPage(workersPage,queryWrapper);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new R("200","添加成功",selectList);
    }

    @Override
    public R deleteWorker(int work_id) {
        try {
            Workers selectById = workerMapper.selectById(work_id);
            if (selectById!=null){
                try {
                    workerMapper.deleteById(work_id);
                } catch (Exception e) {
                    e.printStackTrace();
                    return new R("500","删除工作人员账号失败");
                }
            }else {
                return new R("300","未查找到该工作人员账号");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new R("400","查找工作人员账号失败");
        }
        return new R("200","删除工作人员账号成功");
    }

    @Override
    public IPage<Workers> selectAllWorkers(int size, int page, String name,String state) {
        Page<Workers> workersPage = new Page<>(page,size);
        QueryWrapper queryWrapper = new QueryWrapper();
        if (name!=null && name!=""){
            queryWrapper.like("workname",name);
            queryWrapper.or();
            queryWrapper.like("phone",name);
        }
        if (state!=null){
            if ("unassigned".equals(state)){
                queryWrapper.like("phone","请输入电话号码");
            }
        }

            queryWrapper.orderByAsc("work_id");
        Page selectPage = workerMapper.selectPage(workersPage, queryWrapper);
        return selectPage;
    }

    @Override
    public R selectOneWorker(int work_id) {
        try {
            Workers selectById = workerMapper.selectById(work_id);
            if (selectById!=null){
                return new R("200","查询成功",selectById);
            }
                return new R("300","未找到该用户");
        } catch (Exception e) {
            e.printStackTrace();
            return new R("400","查找出错");
        }

    }

    @Override
    public List<Workers> selectAllWorkersList() {
        List<Workers> workersList = null;
        try {
            workersList = workerMapper.selectList(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return workersList;
    }


}
