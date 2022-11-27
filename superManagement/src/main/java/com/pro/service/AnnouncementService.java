package com.pro.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pro.domain.Announcements;
import com.pro.util.R;
import org.springframework.stereotype.Service;


public interface AnnouncementService {
//    添加公告
    public R insertAnnouncement(Announcements announcements);
//    修改公告信息
    public R updateAnnouncement(Announcements announcements);
//    查找所有公告
    public IPage<Announcements> selectAllAnnouncement(int page,int size);
//    删除单个公告
    public R deleteOneAnnouncement(int a_id);
//    查看单个公告详情
    public R selectOneAnnouncement(int a_id);

}
