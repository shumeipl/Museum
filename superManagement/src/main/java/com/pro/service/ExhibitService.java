package com.pro.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pro.domain.Exhibits;
import com.pro.util.R;

import java.util.List;

public interface ExhibitService {
    public R insertExhibit(Exhibits exhibits);

    public R updateExhibit(Exhibits exhibits);

    public R deleteExhibit(int exhibit_id);

    public IPage<Exhibits> selectAllExhibit(int page,int size);

    public R selectOneExhibit(int exhibit_id);

    public IPage<Exhibits> selectAllExhibitOfState(int page, int size, String venue_name);

    public List<Exhibits> selectAllExhibitList();
}
