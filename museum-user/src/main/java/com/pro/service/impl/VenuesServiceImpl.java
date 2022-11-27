package com.pro.service.impl;

import com.pro.pojo.Venues;
import com.pro.controller.mapper.VenuesMapper;
import com.pro.service.IVenuesService;
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
 * @since 2022-11-25
 */
@Service
public class VenuesServiceImpl extends ServiceImpl<VenuesMapper, Venues> implements IVenuesService {

    @Autowired
    private VenuesMapper venuesMapper;

    /**
     * 查询所有馆
     * @return
     */
    @Override
    public List<Venues> getAllVenues() {
        return venuesMapper.getAllVenues();
    }

    /**
     * 根据名字查询
     * @param venueName
     * @return
     */
    @Override
    public Venues getVenueByName(String venueName) {
        return venuesMapper.getVenueByName(venueName);
    }

    /**
     * 根据id查询
     * @param venueId
     * @return
     */
    @Override
    public Venues getVenueById(Integer venueId) {
        return venuesMapper.getVenueById(venueId);
    }
}
