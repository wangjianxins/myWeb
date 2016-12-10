package com.wangjianxin.service.manager.impl;

import com.wangjianxin.service.dao.AboutMapper;
import com.wangjianxin.service.manager.AboutManager;
import com.wangjianxin.service.model.About;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wangjianxin on 2016/11/4.
 */
@Service
public class AboutManagerImpl implements AboutManager{
    @Autowired
    private AboutMapper aboutMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(About record) {
        return 0;
    }

    @Override
    public int insertSelective(About record) {
        return 0;
    }

    @Override
    public About selectByPrimaryKey(Integer id) {
        About reuslt =  aboutMapper.selectByPrimaryKey(id);
        return reuslt;
    }

    @Override
    public int updateByPrimaryKeySelective(About record) {
        int reuslt =  aboutMapper.updateByPrimaryKey(record);
        return reuslt;
    }

    @Override
    public int updateByPrimaryKey(About record)
    {
       int reuslt =  aboutMapper.updateByPrimaryKey(record);
        return reuslt;
    }

    @Override
    public int countY() {
        int reuslt =  aboutMapper.countY();
        return reuslt;
    }
}
