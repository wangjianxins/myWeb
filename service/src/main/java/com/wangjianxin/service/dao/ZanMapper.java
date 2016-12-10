package com.wangjianxin.service.dao;

import com.wangjianxin.service.model.Zan;
import java.util.List;
import java.util.Map;

public interface ZanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Zan record);

    int insertSelective(Zan record);

    Zan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Zan record);

    int updateByPrimaryKey(Zan record);

    Zan check(Zan zan);

    int updatezan(Map map);
}