package com.pro.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pro.domain.Exhibits;
import com.pro.mapper.ExhibitMapper;
import com.pro.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class ExhibitServiceImpl implements ExhibitService {
    @Autowired
    private ExhibitMapper exhibitMapper;
    @Override
    public R insertExhibit(Exhibits exhibits) {
        try {
            exhibitMapper.insert(exhibits);
        } catch (Exception e) {
            e.printStackTrace();
            return new R("400","添加失败");
        }
        return new R("200","添加成功");
    }

    @Override
    public R updateExhibit(Exhibits exhibits) {
        Exhibits selectById = null;
        try {
            selectById = exhibitMapper.selectById(exhibits.getExhibit_id());
        } catch (Exception e) {
            e.printStackTrace();
            return new R("400","查询失败");
        }
        if (selectById!=null){
            try {
                exhibitMapper.updateById(exhibits);
            } catch (Exception e) {
                e.printStackTrace();
                return new R("400","更新失败");
            }
        }else {
           return new R("300","没有该展览");
        }
        return new R("200","更新成功");
    }

    @Override
    public R deleteExhibit(int exhibit_id) {
        Exhibits selectById = null;
        try {
            selectById = exhibitMapper.selectById(exhibit_id);
        } catch (Exception e) {
            e.printStackTrace();
            return new R("400","查询失败");
        }
        if (selectById!=null){
            try {
                exhibitMapper.deleteById(exhibit_id);
            } catch (Exception e) {
                e.printStackTrace();
                return new R("400","删除失败");
            }
        }else {
            return new R("300","没有该展览");
        }
        return new R("200","删除成功");
    }

    @Override
    public IPage<Exhibits> selectAllExhibit(int page, int size) {
        Page<Exhibits> exhibitsPage = new Page<>(page,size);
        QueryWrapper queryWrapper = new QueryWrapper();
        IPage<Exhibits> selectPage = null;
        try {
            selectPage = exhibitMapper.selectPage(exhibitsPage, queryWrapper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return selectPage;
    }

    @Override
    public R selectOneExhibit(int exhibit_id) {
        Exhibits exhibits = null;
        try {
            exhibits = exhibitMapper.selectById(exhibit_id);
            int capacity = exhibits.getClink();
            exhibits.setClink(capacity+1);
            exhibitMapper.updateById(exhibits);
        } catch (Exception e) {
            e.printStackTrace();
            return new R("400","查询失败");
        }
        return new R("200","查询成功",exhibits);
    }


    @Override
    public IPage<Exhibits> selectAllExhibitOfState(int page, int size, String venue_name) {
        Page<Exhibits> exhibitsPage = new Page<>(page,size);
        QueryWrapper queryWrapper = new QueryWrapper();
        IPage<Exhibits> selectPage = null;
        try {
            if (venue_name!=null && !"".equals(venue_name)){
                queryWrapper.like("venue_name",venue_name);
            }
            selectPage = exhibitMapper.selectPage(exhibitsPage, queryWrapper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return selectPage;
    }

    @Override
    public List<Exhibits> selectAllExhibitList() {
        List<Exhibits> exhibitsList = null;
        try {
            exhibitsList = exhibitMapper.selectList(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exhibitsList;
    }
}
