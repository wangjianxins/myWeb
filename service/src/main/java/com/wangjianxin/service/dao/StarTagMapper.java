package com.wangjianxin.service.dao;

import com.wangjianxin.service.model.StarTag;

public interface StarTagMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StarTag record);

    int insertSelective(StarTag record);

    StarTag selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StarTag record);

    int updateByPrimaryKey(StarTag record);
}