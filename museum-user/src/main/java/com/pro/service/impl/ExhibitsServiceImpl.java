package com.pro.service.impl;

import com.pro.pojo.Exhibits;
import com.pro.controller.mapper.ExhibitsMapper;
import com.pro.service.IExhibitsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xhw
 * @since 2022-11-25
 */
@Service
public class ExhibitsServiceImpl extends ServiceImpl<ExhibitsMapper, Exhibits> implements IExhibitsService {

    @Autowired
    private ExhibitsMapper exhibitsMapper;

    @Override
    public List<Exhibits> getAllExhibits() {
        return exhibitsMapper.getAllExhibits();
    }

    /**
     * 根据状态获取展览
     * @param state
     * @return
     */
    @Override
    public List<Exhibits> getExhibitsByState(Integer state) {
        return exhibitsMapper.getExhibitsByState(state);
    }

    /**
     * 根据状态分页查询
     * @param state
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public List<Exhibits> getExhibitsByStatePage(Integer state, Integer currentPage, Integer pageSize) {
        return exhibitsMapper.getExhibitsByStatePage(state,currentPage,pageSize);
    }

    /**
     * 根据Id查询展览
     * @param exhibitId
     * @return
     */
    @Override
    public Exhibits getExhibitById(Integer exhibitId) {
        return exhibitsMapper.getExhibitById(exhibitId);
    }

    /**
     * 条件查询
     * @return
     */
    @Override
    public List<Exhibits> getExhibitsByStateRange() {
        return exhibitsMapper.getExhibitsByStateRange();
    }
}
