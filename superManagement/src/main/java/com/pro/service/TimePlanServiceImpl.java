package com.pro.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pro.domain.TimePlans;
import com.pro.mapper.TimePlanMapper;
import com.pro.mapper.WorkerMapper;
import com.pro.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class TimePlanServiceImpl implements TimePlanService {
    @Autowired
    private TimePlanMapper timePlanMapper;
    @Autowired
    private WorkerMapper workerMapper;
    @Override
    public R insertTimePlan(TimePlans timePlans) {
        Integer workerCount = null;
        Integer timePlanCount = null;
        try {
            workerCount = workerMapper.selectCount(null);
            timePlanCount = timePlanMapper.selectCount(null);
        } catch (Exception e) {
            e.printStackTrace();
            return new R("400","搜索错误");
        }
        if (timePlanCount < workerCount){
            try {
                timePlanMapper.insert(timePlans);
            } catch (Exception e) {
                e.printStackTrace();
                return new R("400","添加错误");
            }
        }else {
            return new R("300","所有人都排好班了");
        }
        return new R("200","添加成功");
    }

    @Override
    public R updateTimePlan(TimePlans timePlans) {
        try {
            TimePlans selectById = timePlanMapper.selectById(timePlans.getTime_id());
            if (selectById!=null){
                try {
                    timePlanMapper.updateById(timePlans);
                } catch (Exception e) {
                    e.printStackTrace();
                    return new R("400","更新失败");
                }
            }else {
                return new R("300","没有该排班信息");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new R("400","查询失败");
        }
        return new R("200","更新成功");
    }

    @Override
    public IPage<TimePlans> selectAllTimePlans(int page, int size, Integer exhibit_id) {
        Page<TimePlans> timePlansPage = new Page<>(page,size);
        QueryWrapper queryWrapper = new QueryWrapper();
        if (exhibit_id!=null && !"".equals(exhibit_id)){
            queryWrapper.eq("exhibit_id",exhibit_id);
        }
        IPage selectPage = null;
        try {
            selectPage = timePlanMapper.selectPage(timePlansPage, queryWrapper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return selectPage;
    }

    @Override
    public R delete(int time_id) {
        try {
            TimePlans selectById = timePlanMapper.selectById(time_id);
            if (selectById!=null){
                try {
                    timePlanMapper.deleteById(time_id);
                } catch (Exception e) {
                    e.printStackTrace();
                    return new R("400","删除失败");
                }
            }else {
                return new R("300","没有该排班信息");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new R("400","查询失败");
        }
        return new R("200","删除成功");
    }

    @Override
    public R selectOneTimePlan(int time_id) {
        try {
            TimePlans selectById = timePlanMapper.selectById(time_id);
            if (selectById==null){
                return new R("300","没有该排班信息");
            }
            return new R("200","查询成功",selectById);
        } catch (Exception e) {
            e.printStackTrace();
            return new R("400","查询失败");
        }

    }
}
