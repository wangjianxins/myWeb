package com.wangjianxin.service.dao;

import com.wangjianxin.service.model.BaseObject;

import java.io.Serializable;

/**
 * 对象映射基本类
 * Created by zhaobk on 2014/9/15.
 */
public interface BaseObjectMapper<E extends BaseObject, PK extends Serializable> {

    int deleteByPrimaryKey(PK id);

    int insert(E record);

    int insertSelective(E record);

    E selectByPrimaryKey(PK id);

    int updateByPrimaryKeySelective(E record);

    int updateByPrimaryKey(E record);

}
