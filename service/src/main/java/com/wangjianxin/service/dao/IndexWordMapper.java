package com.wangjianxin.service.dao;

import com.wangjianxin.service.model.IndexWord;
import java.util.List;
import java.util.Map;

public interface IndexWordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IndexWord record);

    int insertSelective(IndexWord record);

    IndexWord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IndexWord record);

    int updateByPrimaryKey(IndexWord record);

    String getWord();

    List show(Map map);

    int count();
}