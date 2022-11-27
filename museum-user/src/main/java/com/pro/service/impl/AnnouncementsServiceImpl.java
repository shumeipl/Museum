package com.pro.service.impl;

import com.pro.pojo.Announcements;
import com.pro.controller.mapper.AnnouncementsMapper;
import com.pro.service.IAnnouncementsService;
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
 * @since 2022-11-23
 */
@Service
public class AnnouncementsServiceImpl extends ServiceImpl<AnnouncementsMapper, Announcements> implements IAnnouncementsService {

    @Autowired
    private AnnouncementsMapper announcementsMapper;

    /**
     * 查询所有公告信息
     * @return
     */
    @Override
    public List<Announcements> getAllAnnouncements() {
        return announcementsMapper.getAllAnnouncements();
    }

    /**
     * 分页查询
     * @param currentPage
     * @return
     */
    @Override
    public List<Announcements> getAnnouncementsByPage(Integer currentPage,Integer pageSize) {
        return announcementsMapper.getAnnouncementsByPage(currentPage,pageSize);
    }

    /**
     * 根据id查询公告
     * @param AId
     * @return
     */
    @Override
    public Announcements getAnnouncementById(Integer AId) {
        return announcementsMapper.getAnnouncementById(AId);
    }
}
