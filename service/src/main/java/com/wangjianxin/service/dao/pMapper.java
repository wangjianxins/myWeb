package com.wangjianxin.service.dao;

import com.wangjianxin.service.model.P;

import java.util.Map;
import java.util.List;


public interface pMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(P record);

    int insertSelective(P record);

    P selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(P record);

    int updateByPrimaryKey(P record);

    List initp(Map map);

    int pcount();

    List recommend();

    List howword(int user_id);

    int checkNum(int user_id);

    int look(int p_id);

    int favour(Map map);

    int likenum(int p_id);
}