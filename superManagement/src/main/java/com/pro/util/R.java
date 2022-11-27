package com.pro.util;

import java.util.List;

public class R {
    private String code;
    private String msg;
    private Object object;
    private List<Object> objectList;

    public R() {
    }

    public R(String code, String msg, List<Object> objectList) {
        this.code = code;
        this.msg = msg;
        this.objectList = objectList;
    }

    public R(String code, String msg, Object object) {
        this.code = code;
        this.msg = msg;
        this.object = object;
    }

    public R(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public List<Object> getObjectList() {
        return objectList;
    }

    public void setObjectList(List<Object> objectList) {
        this.objectList = objectList;
    }
}
