package com.wangjianxin.service.manager.impl;

import com.wangjianxin.service.dao.UserFollowMapper;
import com.wangjianxin.service.manager.UserFollowManager;
import com.wangjianxin.service.model.UserFollow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangjianxin on 2017/2/13.
 */
@Service
public class UserFollowManagerImpl implements UserFollowManager {

    @Autowired
    private UserFollowMapper userFollowMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(UserFollow record) {
        return 0;
    }

    @Override
    public int insertSelective(UserFollow record) {
        int result = userFollowMapper.insertSelective(record);
        return result;
    }

    @Override
    public UserFollow selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(UserFollow record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(UserFollow record) {
        return 0;
    }

    @Override
    public UserFollow checkFollow(int user_id, int taguser_id) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("user_id",user_id);
        map.put("taguser_id",taguser_id);
        UserFollow result = userFollowMapper.checkFollow(map);
        return result;
    }

    @Override
    public int Follow(int user_id, int taguser_id, int type) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("user_id",user_id);
        map.put("taguser_id",taguser_id);
        map.put("type",type);
        int result = userFollowMapper.Follow(map);
        return result;
    }
}
