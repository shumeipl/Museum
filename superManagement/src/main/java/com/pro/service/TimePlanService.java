package com.pro.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pro.domain.TimePlans;
import com.pro.util.R;

public interface TimePlanService {
    public R insertTimePlan(TimePlans timePlans);

    public R updateTimePlan(TimePlans timePlans);

    public IPage<TimePlans> selectAllTimePlans(int page,int size,Integer exhibit_id);

    public R delete(int time_id);

    public R selectOneTimePlan(int time_id);
}
