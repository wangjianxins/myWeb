package com.wangjianxin.service.manager.impl;

import com.wangjianxin.service.dao.ArticleMapper;
import com.wangjianxin.service.manager.ArticleManager;
import com.wangjianxin.service.model.Article;
import com.wangjianxin.service.model.BaseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangjianxin on 2016/11/2.
 */
@Service
public class ArticleManagerImpl implements ArticleManager{

    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public int count() {
        int result = articleMapper.count();
        return result;
    }

    @Override
    public int zan(int article_id, int user_id, int type) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("article_id",article_id);
        map.put("user_id",user_id);
        map.put("type",type);
        int result = articleMapper.zan(map);
        return result;
    }

    @Override
    public List paihang() {
        List result = articleMapper.paihang();
        return result;
    }

    @Override
    public List show(int pagenum, int size) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("pagenum",(pagenum-1)*size);
        map.put("size",size);
        List result = articleMapper.show(map);
        return result;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(Article record) {
        return 0;
    }

    @Override
    public int insertSelective(Article record) {
        int result = articleMapper.insertSelective(record);
        return result;
    }

    @Override
    public Article selectByPrimaryKey(Integer id) {
        Article result = articleMapper.selectByPrimaryKey(id);
        return result;
    }

    @Override
    public int updateByPrimaryKeySelective(Article record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Article record) {
        return 0;
    }
}
