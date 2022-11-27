package com.pro.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("exhibits")
public class Exhibits {
    @TableId(type = IdType.AUTO)
    private int exhibit_id;
    private String venue_name;
    private String photo;
    private String type;
    private String location;
    private String open_time;
    private int work_id;
    private String phone;
    private int clink;
    private String content;
    private int capacity;

    public int getExhibit_id() {
        return exhibit_id;
    }

    public void setExhibit_id(int exhibit_id) {
        this.exhibit_id = exhibit_id;
    }

    public String getVenue_name() {
        return venue_name;
    }

    public void setVenue_name(String venue_name) {
        this.venue_name = venue_name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOpen_time() {
        return open_time;
    }

    public void setOpen_time(String open_time) {
        this.open_time = open_time;
    }

    public int getWork_id() {
        return work_id;
    }

    public void setWork_id(int work_id) {
        this.work_id = work_id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getClink() {
        return clink;
    }

    public void setClink(int clink) {
        this.clink = clink;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Exhibits{" +
                "exhibit_id=" + exhibit_id +
                ", venue_name='" + venue_name + '\'' +
                ", photo='" + photo + '\'' +
                ", type='" + type + '\'' +
                ", location='" + location + '\'' +
                ", open_time='" + open_time + '\'' +
                ", work_id=" + work_id +
                ", phone='" + phone + '\'' +
                ", clink=" + clink +
                ", content='" + content + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
