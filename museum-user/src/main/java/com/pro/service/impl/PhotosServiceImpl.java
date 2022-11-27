package com.pro.service.impl;

import com.pro.pojo.Photos;
import com.pro.controller.mapper.PhotosMapper;
import com.pro.service.IPhotosService;
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
public class PhotosServiceImpl extends ServiceImpl<PhotosMapper, Photos> implements IPhotosService {

    @Autowired
    private PhotosMapper photosMapper;

    /**
     * 查询图片
     * @return
     */
    @Override
    public List<Photos> getPhotos() {
        return photosMapper.getPhotos();
    }
}
