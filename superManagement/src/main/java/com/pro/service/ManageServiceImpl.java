package com.pro.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pro.domain.Manages;
import com.pro.mapper.ManagesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManageServiceImpl implements ManageService {
    @Autowired
    private ManagesMapper managesMapper;
    @Override
    public void insertManage(Manages manages) {
        Manages selectOne = selectOne(manages.getManage_id());
        if (selectOne==null) {
            managesMapper.insert(manages);
        }
    }


    @Override
    public void updatePassword(Manages manages) {
        managesMapper.updateById(manages);
    }

    @Override
    public Manages selectOne(int manage_id) {
        Manages manages = managesMapper.selectById(manage_id);
        return manages;
    }

    @Override
    public void deleteManage(int manage_id) {
        managesMapper.deleteById(manage_id);
    }

    @Override
    public IPage<Manages> selectAllManage(int page, int size) {
        Page<Manages> pages = new Page<Manages>(page,size);
        IPage<Manages> managesPage = managesMapper.selectPage(pages, null);
        return managesPage;
    }
}
