package com.wangjianxin.service.model;

import java.util.Date;

public class Star extends BaseObject {
    private Integer id;

    private String starName;

    private String starDes;

    private String starTime;

    private Integer userId;

    private Date time;

    private String photo;

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStarName() {
        return starName;
    }

    public void setStarName(String starName) {
        this.starName = starName == null ? null : starName.trim();
    }

    public String getStarDes() {
        return starDes;
    }

    public void setStarDes(String starDes) {
        this.starDes = starDes == null ? null : starDes.trim();
    }

    public String getStarTime() {
        return starTime;
    }

    public void setStarTime(String starTime) {
        this.starTime = starTime == null ? null : starTime.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}