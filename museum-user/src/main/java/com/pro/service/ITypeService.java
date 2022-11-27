package com.pro.service;

import com.pro.pojo.Type;
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
public interface ITypeService extends IService<Type> {

    /**
     * 查询所有藏品类型
     * @return
     */
    List<Type> getAllType();
}
