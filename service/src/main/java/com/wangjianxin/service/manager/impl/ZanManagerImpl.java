package com.wangjianxin.service.manager.impl;

import com.wangjianxin.service.dao.ZanMapper;
import com.wangjianxin.service.manager.ZanManager;
import com.wangjianxin.service.model.Zan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangjianxin on 2016/11/2.
 */
@Service
public class ZanManagerImpl implements ZanManager{
    @Autowired
    private ZanMapper zanMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(Zan record) {
        return 0;
    }

    @Override
    public int insertSelective(Zan record) {
        int result =  zanMapper.insertSelective(record);
        return result;
    }

    @Override
    public Zan selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Zan record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Zan record) {
        return 0;
    }

    @Override
    public Zan check(Zan zan) {
       Zan result =  zanMapper.check(zan);
        return result;
    }

    @Override
    public int updatezan(int article_id,int user_id, int type) {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("article_id",article_id);
        map.put("user_id",user_id);
        map.put("type",type);
        int result =  zanMapper.updatezan(map);
        return result;
    }
}
