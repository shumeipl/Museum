package com.example.workers.dao;

import com.example.workers.pojo.Attendence;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface AttendenceMapper {
    List<Attendence> selectNums();
}
