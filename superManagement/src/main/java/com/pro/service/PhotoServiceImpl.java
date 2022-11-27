package com.pro.service;

import com.pro.domain.Photos;
import com.pro.mapper.PhotoMapper;
import com.pro.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class PhotoServiceImpl implements PhotoService {
    @Autowired
    private PhotoMapper photoMapper;
    @Override
    public R insertPhotos(Photos photos) {
        Integer integer = photoMapper.selectCount(null);
        if (integer <= 6){
            photoMapper.insert(photos);
        }else {
            return new R("300","轮播图图片已有六张，请进行删除操作后添加");
        }
        return new R("200","轮播图已添加");
    }

    @Override
    public R updatePhoto(Photos photos) {
        Photos selectById = null;
        try {
            selectById = photoMapper.selectById(photos.getPhoto_id());
        } catch (Exception e) {
            e.printStackTrace();
            return new R("400","轮播图查询失败");
        }
        if (selectById!=null){
            try {
                photoMapper.updateById(photos);
            } catch (Exception e) {
                e.printStackTrace();
                return new R("400","轮播图更新失败");
            }
        }else {
            return new R("300","没有该轮播图");
        }
        return new R("200","轮播图更新成功");
    }

    @Override
    public R deletePhotoById(int photo_id) {
        Photos selectById = null;
        try {
            selectById = photoMapper.selectById(photo_id);
        } catch (Exception e) {
            e.printStackTrace();
            return new R("400","轮播图查询失败");
        }
        if (selectById!=null){
            try {
                photoMapper.deleteById(photo_id);
            } catch (Exception e) {
                e.printStackTrace();
                return new R("400","轮播图删除失败");
            }
        }else {
            return new R("300","没有该轮播图");
        }
        return new R("200","轮播图删除成功");
    }

    @Override
    public R selectAllPhotos() {
        List<Photos> photosList = null;
        try {
            photosList = photoMapper.selectList(null);
        } catch (Exception e) {
            e.printStackTrace();
            return new R("400","查询失败");
        }

        return new R("200","查询成功",photosList);
    }
}
