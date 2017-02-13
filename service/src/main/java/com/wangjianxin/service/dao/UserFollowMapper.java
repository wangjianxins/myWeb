package com.wangjianxin.service.dao;

import com.wangjianxin.service.model.UserFollow;

import java.util.Map;

public interface UserFollowMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserFollow record);

    int insertSelective(UserFollow record);

    UserFollow selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserFollow record);

    int updateByPrimaryKey(UserFollow record);

    UserFollow checkFollow(Map map);

    int Follow(Map map);
}