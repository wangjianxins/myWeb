package com.wangjianxin.service.manager.impl;

import com.wangjianxin.service.dao.IndexWordMapper;
import com.wangjianxin.service.manager.IndexWordManager;
import com.wangjianxin.service.model.IndexWord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangjianxin on 2016/11/1.
 */
@Service
public class IndexWordManagerImpl implements IndexWordManager{

    @Autowired
    private IndexWordMapper indexWordMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(IndexWord record) {
        return 0;
    }

    @Override
    public int insertSelective(IndexWord record) {
        return 0;
    }

    @Override
    public IndexWord selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(IndexWord record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(IndexWord record) {
        return 0;
    }

    @Override
    public String getWord() {
        String result = indexWordMapper.getWord();
        return result;
    }

    @Override
    public List show(int pagenum, int size) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("pagenum",(pagenum-1)*size);
        map.put("size",size);
        List result = indexWordMapper.show(map);
        return result;
    }

    @Override
    public int count() {
        int result = indexWordMapper.count();
        return result;
    }
}
