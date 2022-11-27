package com.pro.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pro.domain.Manages;

public interface ManageService {
    /**
     * 在管理员状态添加管理员账号
     * @param manages
     */
    public void insertManage(Manages manages);


    /**
     * 修改密码
     * @param manages
     */
    public void updatePassword(Manages manages);

    /**
     * 查找管理员账号
     * @param manage_id
     * @return
     */
    public Manages selectOne(int manage_id);

    /**
     * 删除管理员账号
     * @param manage_id
     */
    public void deleteManage(int manage_id);

//    查找所有管理员账号
    public IPage<Manages> selectAllManage(int page,int size);
}
