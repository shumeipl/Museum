package com.pro.service;

import com.pro.pojo.Photos;
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
@Service
public interface IPhotosService extends IService<Photos> {

    /**
     * 查询图片
     * @return
     */
    List<Photos> getPhotos();

}
