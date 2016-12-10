package com.wangjianxin.service.manager;

import com.wangjianxin.service.model.BaseObject;
import java.io.Serializable;

/**
 * Created by zhaobk on 2015-08-19.
 * 父接口类，子接口无需再重写下面的方法
 */
public interface BaseObjectManager<E extends BaseObject, PK extends Serializable> {
   int deleteByPrimaryKey(PK id);


    int insert(E record);

    int insertSelective(E record);

    E selectByPrimaryKey(PK id);

    int updateByPrimaryKeySelective(E record);

    int updateByPrimaryKey(E record);
}