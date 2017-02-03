package com.wangjianxin.service.manager.impl;

import com.wangjianxin.service.dao.pMapper;
import com.wangjianxin.service.manager.PManager;
import com.wangjianxin.service.model.Article;
import com.wangjianxin.service.model.BaseObject;
import com.wangjianxin.service.model.P;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangjianxin on 2017/1/16.
 */
@Service
public class PManagerImpl implements PManager {




    @Autowired
    private pMapper p;

    public P select(Integer id) {
        P result = p.selectByPrimaryKey(id);
        return result;
    }
    @Override
    public int deleteByPrimaryKey(Serializable id) {
        return 0;
    }

    @Override
    public int insert(BaseObject record) {
        return 0;
    }

    @Override
    public int insertSelective(BaseObject record) {
        return 0;
    }

    @Override
    public BaseObject selectByPrimaryKey(Serializable id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(BaseObject record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(BaseObject record) {
        return 0;
    }

    @Override
    public List initp(int pagenum, int pagesize) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("pagenum",(pagenum-1)*pagesize);
        map.put("pagesize",pagesize);
        List result = p.initp(map);
        return result;
    }

    @Override
    public int pcount() {
       int result =  p.pcount();
        return result;
    }

    @Override
    public List recommend() {
       List reuslt =  p.recommend();
        return reuslt;
    }

    @Override
    public List howword(int user_id) {
        List reuslt = p.howword(user_id);
        return reuslt;
    }

    @Override
    public P select(int id) {
        P reuslt = p.selectByPrimaryKey(id);
        return reuslt;
    }

    @Override
    public int insertArticle(P ps) {
        int reuslt = p.insertSelective(ps);
        return reuslt;
    }

    @Override
    public int checkNum(int user_id) {
        int reuslt = p.checkNum(user_id);
        return reuslt;
    }

    @Override
    public int look(int p_id) {
        int reuslt = p.look(p_id);
        return reuslt;
    }

    @Override
    public int favour(int p_id, int type) {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("p_id",p_id);
        map.put("type",type);
        int reuslt = p.favour(map);
        return reuslt;
    }

    @Override
    public int likenum(int p_id) {
        int reuslt = p.likenum(p_id);
        return reuslt;
    }
}
