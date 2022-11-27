package com.pro.service;

import com.pro.pojo.Collections;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xhw
 * @since 2022-11-25
 */
@Service
public interface ICollectionsService extends IService<Collections> {

    /**
     * 根据类型查询藏品
     * @param type
     * @return
     */
    List<Collections> getByType(String type);

    /**
     * 根据类型分页查询
     * @param type
     * @param currentPage
     * @param pageSize
     * @return
     */
    List<Collections> getByTypePage(String type,Integer currentPage,Integer pageSize);

    /**
     * 根据Id查询藏品
     * @param collectionId
     * @return
     */
    Collections getCollectionById(Integer collectionId);

}
