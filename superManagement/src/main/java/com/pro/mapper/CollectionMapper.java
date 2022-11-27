package com.pro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pro.domain.Collections;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CollectionMapper extends BaseMapper<Collections> {
}
