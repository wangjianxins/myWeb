package com.wangjianxin.service.model;

import java.util.Date;

public class StarTag {
    private Integer id;

    private Integer starId;

    private String starTagname;

    private Date time;

    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStarId() {
        return starId;
    }

    public void setStarId(Integer starId) {
        this.starId = starId;
    }

    public String getStarTagname() {
        return starTagname;
    }

    public void setStarTagname(String starTagname) {
        this.starTagname = starTagname == null ? null : starTagname.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}