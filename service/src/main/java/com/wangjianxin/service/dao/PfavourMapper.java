package com.wangjianxin.service.dao;

import com.wangjianxin.service.model.Pfavour;

import java.util.Map;

public interface PfavourMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Pfavour record);

    int insertSelective(Pfavour record);

    Pfavour selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Pfavour record);

    int updateByPrimaryKey(Pfavour record);

    Pfavour checkFavour(Map map);

    int updateFavour(Map map);
}