package com.entity;

import com.alibaba.fastjson.JSONObject;


public class Message {

    private String code;

    private String msg;

    private boolean status = false;

    private String data;

    public Message (String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Message (String code, String msg, boolean status) {
        this.code = code;
        this.msg = msg;
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public JSONObject getReturnInfo () {
        JSONObject json = new JSONObject();
        json.put("code", this.code);
        json.put("msg", this.msg);
        return json;
    }
}
