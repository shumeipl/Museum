package com.pro.service.impl;

import com.pro.pojo.Type;
import com.pro.controller.mapper.TypeMapper;
import com.pro.service.ITypeService;
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
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type> implements ITypeService {

    @Autowired
    private TypeMapper typeMapper;

    /**
     * 查询所有藏品类型
     * @return
     */
    @Override
    public List<Type> getAllType() {
        return typeMapper.getAllType();
    }
}
