package com.pro.service;

import com.pro.pojo.Announcements;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xhw
 * @since 2022-11-23
 */
public interface IAnnouncementsService extends IService<Announcements> {

    /**
     * 查询所有公告信息
     * @return
     */
    List<Announcements> getAllAnnouncements();

    /**
     * 分页查询
     * @param currentPage
     * @return
     */
    List<Announcements> getAnnouncementsByPage(Integer currentPage,Integer pageSize);

    /**
     * 根据id查询公告
     * @param AId
     * @return
     */
    Announcements getAnnouncementById(Integer AId);
}
