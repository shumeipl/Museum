package com.pro.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pro.domain.Announcements;
import com.pro.mapper.AnnouncementMapper;
import com.pro.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {
    @Autowired
    private AnnouncementMapper announcementMapper;

    @Override
    public R insertAnnouncement(Announcements announcements) {
        if (announcements != null) {
            try {
                announcementMapper.insert(announcements);
            } catch (Exception e) {
                e.printStackTrace();
                return new R("400", "添加失败");
            }
            return new R("200", "添加成功");
        } else
            return new R("300", "添加的公告为空");

    }

    @Override
    public R updateAnnouncement(Announcements announcements) {
        if (announcements != null) {
            Announcements selectById = null;
            try {
                selectById = announcementMapper.selectById(announcements.getA_id());
            } catch (Exception e) {
                e.printStackTrace();
                return new R("300", "公告搜索出错");
            }
            if (selectById != null) {
                try {
                    announcementMapper.updateById(announcements);
                } catch (Exception e) {
                    e.printStackTrace();
                    return new R("300", "公告更新出错");
                }
            } else {
                return new R("300", "没有该公告");
            }
            return new R("200", "更新的公告成功");
        } else
            return new R("300", "更新的公告为空");
    }

    @Override
    public IPage<Announcements> selectAllAnnouncement(int page, int size) {
        Page<Announcements> announcementsPage = new Page<>(page, size);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.orderByDesc("a_id");
        IPage<Announcements> selectPage = null;
        try {
            selectPage = announcementMapper.selectPage(announcementsPage, queryWrapper);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return selectPage;
    }

    @Override
    public R deleteOneAnnouncement(int a_id) {
        if (a_id != 0) {
            Announcements selectById = null;
            try {
                selectById = announcementMapper.selectById(a_id);
            } catch (Exception e) {
                e.printStackTrace();
                return new R("300", "公告搜索出错");
            }
            if (selectById != null) {
                try {
                    announcementMapper.deleteById(a_id);
                } catch (Exception e) {
                    e.printStackTrace();
                    return new R("300", "公告删除出错");
                }
            } else {
                return new R("300", "没有该公告");
            }
            return new R("200", "删除公告成功");
        } else
            return new R("300", "删除的公告为空");
    }

    @Override
    public R selectOneAnnouncement(int a_id) {
        try {
            Announcements announcements = announcementMapper.selectById(a_id);
            return new R("200","查询成功",announcements);
        } catch (Exception e) {
            e.printStackTrace();
            return new R("400","查询失败");
        }

    }
}
