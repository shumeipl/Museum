package com.pro.controller.mapper;

import com.pro.pojo.Announcements;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xhw
 * @since 2022-11-23
 */
@Mapper
@Repository
public interface AnnouncementsMapper extends BaseMapper<Announcements> {

    /**
     * 查询所有公告信息
     * @return
     */
    List<Announcements> getAllAnnouncements();

    /**
     *分页查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    List<Announcements> getAnnouncementsByPage(@Param("currentPage")Integer currentPage,@Param("pageSize")Integer pageSize);

    /**
     * 根据id查询公告
     * @param AId
     * @return
     */
    Announcements getAnnouncementById(Integer AId);
 }
