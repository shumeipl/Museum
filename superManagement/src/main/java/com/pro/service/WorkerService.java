package com.pro.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pro.domain.Workers;
import com.pro.util.R;

import java.util.List;

public interface WorkerService {
//    添加员工
public R insertWorker(Integer page,Integer size);
//    删除员工
    public R deleteWorker(int work_id);
//    查看员工,分页(name为搜索时所用的条件)
public IPage<Workers> selectAllWorkers(int size, int page, String name,String state) ;
//    查找单个员工
    public R selectOneWorker(int work_id);
//查询所有员工
    public List<Workers> selectAllWorkersList();
}
