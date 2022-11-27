package com.pro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pro.domain.Manages;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ManagesMapper extends BaseMapper<Manages> {
}
