package com.pro.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pro.domain.Collections;
import com.pro.mapper.CollectionMapper;
import com.pro.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectionServiceImpl implements CollectionService {
    @Autowired
    private CollectionMapper collectionMapper;
    @Override
    public R insertCollection(Collections collections) {
        QueryWrapper<Collections> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",collections.getName());
        Collections selectOne = null;
        try {
            selectOne = collectionMapper.selectOne(queryWrapper);
        } catch (Exception e) {
            e.printStackTrace();
            return new R("400","查询失败");
        }
        if (selectOne==null){
            try {
                collectionMapper.insert(collections);
            } catch (Exception e) {
                e.printStackTrace();
                return new R("400","添加失败");
            }
        }else {
            return new R("300","藏品名称重复");
        }

        return new R("200","添加成功");
    }

    @Override
    public R updateCollection(Collections collections) {
        Collections selectById = null;
        try {
            selectById = collectionMapper.selectById(collections.getCollection_id());
        } catch (Exception e) {
            e.printStackTrace();
            return new R("400","查询失败");
        }
        if (selectById!=null){
            try {
                collectionMapper.updateById(collections);
            } catch (Exception e) {
                e.printStackTrace();
                return new R("400","修改失败");
            }
        }else {
            return new R("300","没查到该藏品信息");
        }
        return new R("200","修改成功");
    }

    @Override
    public R deleteCollection(int collection_id) {
        Collections selectById = null;
        try {
            selectById = collectionMapper.selectById(collection_id);
        } catch (Exception e) {
            e.printStackTrace();
            return new R("400","查询失败");
        }
        if (selectById!=null){
            try {
                collectionMapper.deleteById(collection_id);
            } catch (Exception e) {
                e.printStackTrace();
                return new R("400","删除失败");
            }
        }else {
            return new R("300","没查到该藏品信息");
        }
        return new R("200","删除成功");
    }

    @Override
    public R selectOneCollection(int collection_id) {
        Collections collections = null;
        try {
            collections = collectionMapper.selectById(collection_id);
        } catch (Exception e) {
            e.printStackTrace();
            return new R("400","查询失败");
        }
        return new R("200","查询成功",collections);
    }

    @Override
    public IPage<Collections> selectAllCollection(int page, int size, String name, String state) {
        Page<Collections> collectionsPage = new Page<>(page,size);
        QueryWrapper queryWrapper = new QueryWrapper();
        if (name!=null && !"".equals(name)){
            queryWrapper.like("name",name);
        }
        if (state!=null && !"".equals(state)){
            if ("click".equals(state)){
                queryWrapper.orderByDesc("click");
            }else {
                queryWrapper.orderByDesc("year");
            }
        }
        IPage selectPage = null;
        try {
            selectPage = collectionMapper.selectPage(collectionsPage, queryWrapper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return selectPage;
    }
}
