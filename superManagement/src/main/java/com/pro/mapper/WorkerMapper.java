package com.pro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pro.domain.Workers;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface WorkerMapper extends BaseMapper<Workers> {
}
