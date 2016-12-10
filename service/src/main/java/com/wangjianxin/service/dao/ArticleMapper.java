package com.wangjianxin.service.dao;

import com.wangjianxin.service.model.Article;

import java.util.List;
import java.util.Map;

public interface ArticleMapper extends BaseObjectMapper{
    int deleteByPrimaryKey(Integer id);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);

    List show(Map map);

    int count();

    int zan(Map map);

    List paihang();
}