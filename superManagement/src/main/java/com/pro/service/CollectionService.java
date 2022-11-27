package com.pro.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pro.domain.Collections;
import com.pro.util.R;

public interface CollectionService {
    public R insertCollection(Collections collections);

    public R updateCollection(Collections collections);

    public R deleteCollection(int collection_id);

    public R selectOneCollection(int collection_id);

    public IPage<Collections> selectAllCollection(int page,int size,String name,String state);
}
