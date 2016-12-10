package com.wangjianxin.service.manager.impl;

import com.wangjianxin.service.dao.StarMapper;
import com.wangjianxin.service.manager.StarManager;
import com.wangjianxin.service.model.Star;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wangjianxin on 2016/11/16.
 */
@Service
public class StarManagerImpl implements StarManager{

    @Autowired
    private StarMapper starMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(Star record) {
        return 0;
    }

    @Override
    public int insertSelective(Star record) {
        int result = starMapper.insertSelective(record);
        return result;
    }

    @Override
    public Star selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Star record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Star record) {
        return 0;
    }

    @Override
    public List selectAll() {
        List result = starMapper.selectAll();
        return result;
    }
}
