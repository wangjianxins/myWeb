package com.wangjianxin.service.model;

import java.util.Date;

public class UserFollow extends BaseObject {
    private Integer id;

    private Integer userId;

    private Integer taguserId;

    private Date createtime;

    private Integer flag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTaguserId() {
        return taguserId;
    }

    public void setTaguserId(Integer taguserId) {
        this.taguserId = taguserId;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}