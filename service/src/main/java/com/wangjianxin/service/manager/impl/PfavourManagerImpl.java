package com.wangjianxin.service.manager.impl;

import com.wangjianxin.service.dao.PfavourMapper;
import com.wangjianxin.service.manager.PfavourManager;
import com.wangjianxin.service.model.Pfavour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangjianxin on 2017/2/3.
 */
@Service
public class PfavourManagerImpl implements PfavourManager {

    @Autowired
    private PfavourMapper pfavourMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(Pfavour record) {
        return 0;
    }

    @Override
    public int insertSelective(Pfavour record) {
        int result =  pfavourMapper.insertSelective(record);
        return result;
    }

    @Override
    public Pfavour selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Pfavour record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Pfavour record) {
        return 0;
    }

    @Override
    public Pfavour checkFavour(int user_id,int p_id) {
        Map<String,Object> map =new HashMap<String, Object>();
        map.put("user_id",user_id);
        map.put("p_id",p_id);
       Pfavour result =  pfavourMapper.checkFavour(map);
        return result;
    }

    @Override
    public int updateFavour(int user_id, int type, int p_id) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("user_id",user_id);
        map.put("type",type);
        map.put("p_id",p_id);
//        System.out.print(map.get("p_id"));

        int result =  pfavourMapper.updateFavour(map);
        return result;
    }
}
