package com.wangjianxin.service.dao;

import com.wangjianxin.service.model.About;

public interface AboutMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(About record);

    int insertSelective(About record);

    About selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(About record);

    int updateByPrimaryKey(About record);

    int countY();
}