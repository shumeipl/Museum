package com.pro.service.impl;

import com.pro.pojo.Collections;
import com.pro.controller.mapper.CollectionsMapper;
import com.pro.service.ICollectionsService;
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
public class CollectionsServiceImpl extends ServiceImpl<CollectionsMapper, Collections> implements ICollectionsService {

    @Autowired
    private CollectionsMapper collectionsMapper;

    /**
     * 根据类型查询藏品
     * @param type
     * @return
     */
    @Override
    public List<Collections> getByType(String type) {
        return collectionsMapper.getByType(type);
    }

    /**
     * 根据类型分页查询
     * @param type
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public List<Collections> getByTypePage(String type, Integer currentPage, Integer pageSize) {
        return collectionsMapper.getByTypePage(type,currentPage,pageSize);
    }

    /**
     * 跟据id查询藏品
     * @param collectionId
     * @return
     */
    @Override
    public Collections getCollectionById(Integer collectionId) {
        return collectionsMapper.getCollectionById(collectionId);
    }
}
