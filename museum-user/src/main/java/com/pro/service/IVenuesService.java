package com.pro.service;

import com.pro.pojo.Venues;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xhw
 * @since 2022-11-25
 */
@Service
public interface IVenuesService extends IService<Venues> {

    /**
     * 查询所有馆
     * @return
     */
    List<Venues> getAllVenues();

    /**
     * 根据名字查询
     * @param venueName
     * @return
     */
    Venues getVenueByName(String venueName);

    /**
     * 根据id查询
     * @param venueId
     * @return
     */
    Venues getVenueById(Integer venueId);

}
