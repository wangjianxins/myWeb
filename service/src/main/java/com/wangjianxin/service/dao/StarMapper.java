package com.wangjianxin.service.dao;

import com.wangjianxin.service.model.Star;
import java.util.List;
import java.util.Map;

public interface StarMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Star record);

    int insertSelective(Star record);

    Star selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Star record);

    int updateByPrimaryKey(Star record);

    List selectAll();

    List check(Map map);
}