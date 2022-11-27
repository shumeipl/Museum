package com.pro.service;

import com.pro.domain.Photos;
import com.pro.util.R;

public interface PhotoService {
    public R insertPhotos(Photos photos);

    public R updatePhoto(Photos photos);

    public R deletePhotoById(int photo_id);

    public R selectAllPhotos();
}
