package com.pro.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("manages")
public class Manages {
    @TableId(type = IdType.AUTO)
    private int manage_id;
    private String password;
    private int slat;

    @Override
    public String toString() {
        return "Manages{" +
                "manager_id=" + manage_id +
                ", password='" + password + '\'' +
                ", slat=" + slat +
                '}';
    }

    public Manages(int manage_id, String password) {
        this.manage_id = manage_id;
        this.password = password;
    }

    public Manages() {
    }

    public int getManage_id() {
        return manage_id;
    }

    public void setManage_id(int manage_id) {
        this.manage_id = manage_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSlat() {
        return slat;
    }

    public void setSlat(int slat) {
        this.slat = slat;
    }
}
